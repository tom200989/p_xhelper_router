package com.p_xhelper_smart.p_xhelper_smart.helper;

import com.p_encrypt.p_encrypt.core.md5.Md5Code;
import com.p_xhelper_smart.p_xhelper_smart.bean.LoginBean;
import com.p_xhelper_smart.p_xhelper_smart.bean.LoginParam;
import com.p_xhelper_smart.p_xhelper_smart.bean.SystemInfoBean;
import com.p_xhelper_smart.p_xhelper_smart.core.XSmart;
import com.p_xhelper_smart.p_xhelper_smart.impl.FwError;
import com.p_xhelper_smart.p_xhelper_smart.impl.XNormalCallback;
import com.p_xhelper_smart.p_xhelper_smart.utils.Cons;
import com.p_xhelper_smart.p_xhelper_smart.utils.EncryptUtils;
import com.p_xhelper_smart.p_xhelper_smart.utils.SmartUtils;

/*
 * Created by qianli.ma on 2019/7/29 0029.
 */
@SuppressWarnings("unchecked")
public class LoginHelper extends BaseHelper {

    private String account;
    private String password;
    private int count = 0;
    private int devType;// 设备类型
    private SystemInfoBean systemInfoBean;

    /**
     * 登陆
     *
     * @param account  用户名
     * @param password 密码
     */
    public void login(String account, String password) {

        this.account = account;
        this.password = password;
        count = 0;
        prepareHelperNext();
        // 判断是否为E1版本
        is_DEV_E1();
    }

    /**
     * 判断是否为E1版本
     */
    private void is_DEV_E1() {
        GetSystemInfoHelper xSystemHelper = new GetSystemInfoHelper();
        xSystemHelper.setOnGetSystemInfoSuccessListener(systemInfobean -> {
            // 0.提交本地变量
            this.systemInfoBean = systemInfobean;
            devType = SmartUtils.getDEVType(systemInfobean.getDeviceName());
            // 1.判断是否为E1版本
            if (devType == Cons.DEV_TARGET) {
                // 1.1.E1版本必须加密
                encryptAccAndPsd(true);
            } else {
                // 1.2.非E1版本, 判断是否有加密字段PwEncrypt
                isPwEncrypt();
            }
        });

        xSystemHelper.setOnFwErrorListener(() -> {
            // 1.3.如果获取出错 -- 则一定是需要加密的版本
            encryptAccAndPsd(true);
        });
        xSystemHelper.setOnAppErrorListener(this::loginFailedNext);
        xSystemHelper.getSystemInfo();
    }

    /**
     * 非E1版本, 判断是否有加密字段PwEncrypt
     */
    private void isPwEncrypt() {
        GetLoginStateHelper loginStateHelper = new GetLoginStateHelper();
        loginStateHelper.setOnGetLoginStateSuccessListener(loginStateBean -> {
            // 获取PW-ENCRYPT字段: 1 -- 需要加密; 0 -- 不需要加密
            boolean isEncrypt = loginStateBean.getPwEncrypt() == Cons.CONS_PWENCRYPT_ON;
            // 进行加密操作
            encryptAccAndPsd(isEncrypt);
            // 正式发起请求
            reqLogin();
        });
        loginStateHelper.setOnGetLoginStateFailedListener(this::loginFailedNext);
        loginStateHelper.getLoginState();
    }

    /**
     * 正式发起请求
     */
    private void reqLogin() {
        XSmart<LoginBean> xLogin = new XSmart<>();
        xLogin.xParam(new LoginParam(account, password));
        xLogin.xMethod(Cons.METHOD_LOGIN).xPost(new XNormalCallback<LoginBean>() {
            @Override
            public void success(LoginBean loginBean) {
                isStateLogin(loginBean);// 查询登陆状态是否已经更改为［已登录］
            }

            @Override
            public void appError(Throwable ex) {
                loginFailedNext();
            }

            @Override
            public void fwError(FwError fwError) {
                loginFailedNext();
            }

            @Override
            public void finish() {
                doneHelperNext();
            }
        });
    }

    /**
     * 查询登陆状态是否已经更改为［已登录］
     */
    private void isStateLogin(LoginBean loginBean) {
        GetLoginStateHelper xLoginState = new GetLoginStateHelper();
        xLoginState.setOnGetLoginStateSuccessListener(loginStateBean -> {
            int state = loginStateBean.getState();
            if (state == Cons.CONS_LOGIN) {/* 登陆成功 */
                // 查询辅助标记置零
                count = 0;
                // 更新token
                updateToken(loginBean);
                // 回调
                loginSuccessNext();

            } else if (state == Cons.CONS_LOGOUT) {/* 依然是登出状态 */
                if (count < 5) {// 小于5次 -- 则重复确认
                    try {
                        Thread.sleep(1000);
                        isStateLogin(loginBean);// 重复请求
                        count++;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    count = 0;
                    loginFailedNext();
                }

            } else if (state == Cons.CONS_LOGIN_TIME_USER_OUT) {/* 登陆次数超限 */
                loginOutTimeNext();

            }
        });
        xLoginState.setOnGetLoginStateFailedListener(this::loginFailedNext);
        xLoginState.getLoginState();
    }

    /**
     * 更新token
     *
     * @param loginBean 登陆后返回的token
     */
    private void updateToken(LoginBean loginBean) {
        String token = loginBean.getToken();
        String key = loginBean.getKey();
        String iv = loginBean.getIv();
        String deviceName = systemInfoBean.getDeviceName();
        XSmart.token = EncryptUtils.encryptToken(token, key, iv, deviceName);
    }

    /**
     * 对帐号和用户名进行加密
     *
     * @param isEncrypt T:需要加密
     */
    private void encryptAccAndPsd(boolean isEncrypt) {
        // 账户名加密 (均为普通算法加密)
        account = isEncrypt ? EncryptUtils.encryptAdmin(account) : account;
        // 密码加密 (分为算法加密或者MD5加密)
        if (isEncrypt) {
            if (systemInfoBean != null) {
                // 如果不是［新设备］-- 采用普通算法加密
                if (devType != Cons.DEV_2019) {
                    password = EncryptUtils.encryptAdmin(password);
                } else {// 如果是［新设备］-- 采用MD5加密
                    password = Md5Code.encryption(password).toLowerCase();
                }
            }
        }
    }

    /* -------------------------------------------- impl -------------------------------------------- */

    private OnLoginSuccesListener onLoginSuccesListener;

    // Inteerface--> 接口OnLoginSuccesListener
    public interface OnLoginSuccesListener {
        void loginSuccess();
    }

    // 对外方式setOnLoginSuccesListener
    public void setOnLoginSuccesListener(OnLoginSuccesListener onLoginSuccesListener) {
        this.onLoginSuccesListener = onLoginSuccesListener;
    }

    // 封装方法loginSuccessNext
    private void loginSuccessNext() {
        if (onLoginSuccesListener != null) {
            onLoginSuccesListener.loginSuccess();
        }
    }

    private OnLoginFailedListener onLoginFailedListener;

    // Inteerface--> 接口OnLoginFailedListener
    public interface OnLoginFailedListener {
        void loginFailed();
    }

    // 对外方式setOnLoginFailedListener
    public void setOnLoginFailedListener(OnLoginFailedListener onLoginFailedListener) {
        this.onLoginFailedListener = onLoginFailedListener;
    }

    // 封装方法loginFailedNext
    private void loginFailedNext() {
        if (onLoginFailedListener != null) {
            onLoginFailedListener.loginFailed();
        }
    }

    private OnLoginOutTimeListener onLoginOutTimeListener;

    // Inteerface--> 接口OnLoginOutTimeListener
    public interface OnLoginOutTimeListener {
        void loginOutTime();
    }

    // 对外方式setOnLoginOutTimeListener
    public void setOnLoginOutTimeListener(OnLoginOutTimeListener onLoginOutTimeListener) {
        this.onLoginOutTimeListener = onLoginOutTimeListener;
    }

    // 封装方法loginOutTimeNext
    private void loginOutTimeNext() {
        if (onLoginOutTimeListener != null) {
            onLoginOutTimeListener.loginOutTime();
        }
    }

}
