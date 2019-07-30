package com.p_xhelper_smart.p_xhelper_smart.helper;

import com.p_xhelper_smart.p_xhelper_smart.bean.GetSimStatusBean;
import com.p_xhelper_smart.p_xhelper_smart.core.XSmart;
import com.p_xhelper_smart.p_xhelper_smart.impl.FwError;
import com.p_xhelper_smart.p_xhelper_smart.impl.XNormalCallback;
import com.p_xhelper_smart.p_xhelper_smart.utils.Cons;
import com.p_xhelper_smart.p_xhelper_smart.utils.Logg;

/*
 * Created by qianli.ma on 2019/7/30 0030.
 */
public class GetSimStatusHelper extends BaseHelper {

    public void getSimStatus() {
        prepareHelperNext();
        XSmart<GetSimStatusBean> xSimStatus = new XSmart<>();
        xSimStatus.xMethod(Cons.METHOD_GET_SIM_STATUS).xPost(new XNormalCallback<GetSimStatusBean>() {
            @Override
            public void success(GetSimStatusBean simStatusBean) {
                // TODO: 2019/7/30 0030  测试是否能获取到
                Logg.t("ma_test_ui").ii(simStatusBean.toString());
            }

            @Override
            public void appError(Throwable ex) {
                getSimStatusFailedNext();
            }

            @Override
            public void fwError(FwError fwError) {
                getSimStatusFailedNext();
            }

            @Override
            public void finish() {
                doneHelperNext();
            }
        });
    }

    /* -------------------------------------------- impl -------------------------------------------- */

    private OnGetSimStatusFailedListener onGetSimStatusFailedListener;

    // Inteerface--> 接口OnGetSimStatusFailedListener
    public interface OnGetSimStatusFailedListener {
        void getSimStatusFailed();
    }

    // 对外方式setOnGetSimStatusFailedListener
    public void setOnGetSimStatusFailedListener(OnGetSimStatusFailedListener onGetSimStatusFailedListener) {
        this.onGetSimStatusFailedListener = onGetSimStatusFailedListener;
    }

    // 封装方法getSimStatusFailedNext
    private void getSimStatusFailedNext() {
        if (onGetSimStatusFailedListener != null) {
            onGetSimStatusFailedListener.getSimStatusFailed();
        }
    }
}
