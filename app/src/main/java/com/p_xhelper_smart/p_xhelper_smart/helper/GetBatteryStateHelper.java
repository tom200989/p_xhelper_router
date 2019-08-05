package com.p_xhelper_smart.p_xhelper_smart.helper;

import com.p_xhelper_smart.p_xhelper_smart.bean.GetBatteryStateBean;
import com.p_xhelper_smart.p_xhelper_smart.core.XSmart;
import com.p_xhelper_smart.p_xhelper_smart.impl.FwError;
import com.p_xhelper_smart.p_xhelper_smart.impl.XNormalCallback;
import com.p_xhelper_smart.p_xhelper_smart.utils.Cons;

/**
 * Created by wzhiqiang on 2019/7/30
 */
public class GetBatteryStateHelper extends BaseHelper {

    public void getBatteryState() {
        prepareHelperNext();
        XSmart<GetBatteryStateBean> xSmart = new XSmart<>();
        xSmart.xMethod(Cons.METHOD_GET_BATTERY_STATE).xPost(new XNormalCallback<GetBatteryStateBean>() {
            @Override
            public void success(GetBatteryStateBean result) {
                getBatteryStateSuccessNext(result);
            }

            @Override
            public void appError(Throwable ex) {
                getBatteryStateFailNext();
            }

            @Override
            public void fwError(FwError fwError) {
                getBatteryStateFailNext();
            }

            @Override
            public void finish() {
                doneHelperNext();
            }
        });
    }

    /*----------------------------------获取电池状态成功回调------------------------------*/
    public interface OnGetBatteryStateSuccessListener {
        void getBatteryStateSuccess(GetBatteryStateBean bean);
    }

    private OnGetBatteryStateSuccessListener onGetBatteryStateSuccessListener;

    //对外方式setOnGetBatteryStateSuccessListener
    public void setOnGetBatteryStateSuccessListener(OnGetBatteryStateSuccessListener onGetBatteryStateSuccessListener) {
        this.onGetBatteryStateSuccessListener = onGetBatteryStateSuccessListener;
    }

    //封装方法getBatteryStateSuccessNext
    private void getBatteryStateSuccessNext(GetBatteryStateBean bean) {
        if (onGetBatteryStateSuccessListener != null) {
            onGetBatteryStateSuccessListener.getBatteryStateSuccess(bean);
        }
    }


    /*----------------------------------获取电池状态失败回调------------------------------*/
    public interface OnGetBatteryStateFailListener {
        void getBatterStateFail();
    }

    private OnGetBatteryStateFailListener onGetBatteryStateFailListener;

    //对外方式setOnGetBatteryStateFailListener
    public void setOnGetBatteryStateFailListener(OnGetBatteryStateFailListener onGetBatteryStateFailListener) {
        this.onGetBatteryStateFailListener = onGetBatteryStateFailListener;
    }

    //封装方法getBatteryStateFailNext
    private void getBatteryStateFailNext() {
        if (onGetBatteryStateFailListener != null) {
            onGetBatteryStateFailListener.getBatterStateFail();
        }
    }
}
