package com.p_xhelper_smart.p_xhelper_smart.helper;

import com.p_xhelper_smart.p_xhelper_smart.bean.SystemInfoBean;
import com.p_xhelper_smart.p_xhelper_smart.core.XSmart;
import com.p_xhelper_smart.p_xhelper_smart.impl.FwError;
import com.p_xhelper_smart.p_xhelper_smart.impl.XNormalCallback;
import com.p_xhelper_smart.p_xhelper_smart.utils.Cons;

/*
 * Created by qianli.ma on 2019/7/29 0029.
 */
public class GetSystemInfoHelper extends BaseHelper {

    /**
     * 获取系统信息
     */
    public void getSystemInfo() {
        prepareHelperNext();
        XSmart<SystemInfoBean> xsmart = new XSmart<>();
        xsmart.xMethod(Cons.METHOD_GET_SYSTEM_INFO).xPost(new XNormalCallback<SystemInfoBean>() {
            @Override
            public void success(SystemInfoBean systemInfoBean) {
                getSystemInfoSuccessNext(systemInfoBean);
            }

            @Override
            public void appError(Throwable ex) {
                appErrorNext();
            }

            @Override
            public void fwError(FwError fwError) {
                fwErrorNext();
            }

            @Override
            public void finish() {
                doneHelperNext();
            }
        });
    }

    private OnGetSystemInfoSuccessListener onGetSystemInfoSuccessListener;

    // Inteerface--> 接口OnGetSystemInfoSuccessListener
    public interface OnGetSystemInfoSuccessListener {
        void getSystemInfoSuccess(SystemInfoBean systemInfobean);
    }

    // 对外方式setOnGetSystemInfoSuccessListener
    public void setOnGetSystemInfoSuccessListener(OnGetSystemInfoSuccessListener onGetSystemInfoSuccessListener) {
        this.onGetSystemInfoSuccessListener = onGetSystemInfoSuccessListener;
    }

    // 封装方法getSystemInfoSuccessNext
    private void getSystemInfoSuccessNext(SystemInfoBean systemInfobean) {
        if (onGetSystemInfoSuccessListener != null) {
            onGetSystemInfoSuccessListener.getSystemInfoSuccess(systemInfobean);
        }
    }

    private OnAppErrorListener onAppErrorListener;

    // Inteerface--> 接口OnAppErrorListener
    public interface OnAppErrorListener {
        void appError();
    }

    // 对外方式setOnAppErrorListener
    public void setOnAppErrorListener(OnAppErrorListener onAppErrorListener) {
        this.onAppErrorListener = onAppErrorListener;
    }

    // 封装方法appErrorNext
    private void appErrorNext() {
        if (onAppErrorListener != null) {
            onAppErrorListener.appError();
        }
    }

    private OnFwErrorListener onFwErrorListener;

    // Inteerface--> 接口OnFwErrorListener
    public interface OnFwErrorListener {
        void fwError();
    }

    // 对外方式setOnFwErrorListener
    public void setOnFwErrorListener(OnFwErrorListener onFwErrorListener) {
        this.onFwErrorListener = onFwErrorListener;
    }

    // 封装方法fwErrorNext
    private void fwErrorNext() {
        if (onFwErrorListener != null) {
            onFwErrorListener.fwError();
        }
    }

}
