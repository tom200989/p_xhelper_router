package com.p_xhelper_smart.p_xhelper_smart.helper;

import com.p_xhelper_smart.p_xhelper_smart.bean.GetSingleSMSBean;
import com.p_xhelper_smart.p_xhelper_smart.bean.GetSingleSMSParam;
import com.p_xhelper_smart.p_xhelper_smart.core.XSmart;
import com.p_xhelper_smart.p_xhelper_smart.impl.FwError;
import com.p_xhelper_smart.p_xhelper_smart.impl.XNormalCallback;
import com.p_xhelper_smart.p_xhelper_smart.utils.Cons;

/**
 * Created by wzhiqiang on 2019/7/30
 */
public class GetSingleSMSHelper extends BaseHelper {

    /**
     * 获取单条短信
     */
    public void getSingleSMS(int smsId) {
        prepareHelperNext();
        GetSingleSMSParam param = new GetSingleSMSParam(smsId);
        XSmart<GetSingleSMSBean> xSmart = new XSmart<>();
        xSmart.xMethod(Cons.METHOD_GET_SINGLE_SMS).xParam(param).xPost(new XNormalCallback<GetSingleSMSBean>() {
            @Override
            public void success(GetSingleSMSBean result) {
                getSingleSmsSuccessNext(result);
            }

            @Override
            public void appError(Throwable ex) {
                getSingleSmsFailNext();
            }

            @Override
            public void fwError(FwError fwError) {
                getSingleSmsFailNext();
            }

            @Override
            public void finish() {
                doneHelperNext();
            }
        });
    }

    /*----------------------------------获取单条短信成功的回调------------------------------*/
    public interface OnGetSingleSMSSuccessListener {
        void getSingleSmsSuccess(GetSingleSMSBean bean);
    }

    private OnGetSingleSMSSuccessListener onGetSingleSMSSuccessListener;

    //对外方式setOnGetSingleSMSSuccessListener
    public void setOnGetSingleSMSSuccessListener(OnGetSingleSMSSuccessListener onGetSingleSMSSuccessListener) {
        this.onGetSingleSMSSuccessListener = onGetSingleSMSSuccessListener;
    }

    //封装方法 getSingleSmsSuccessNext
    private void getSingleSmsSuccessNext(GetSingleSMSBean bean) {
        if (onGetSingleSMSSuccessListener != null) {
            onGetSingleSMSSuccessListener.getSingleSmsSuccess(bean);
        }
    }

    /*----------------------------------获取单条短信失败的回调------------------------------*/
    public interface OnGetSingleSmsFailListener {
        void getSingleSmsFail();
    }

    private OnGetSingleSmsFailListener onGetSingleSmsFailListener;

    //对外方式setOnGetSingleSmsFailListener
    public void setOnGetSingleSmsFailListener(OnGetSingleSmsFailListener onGetSingleSmsFailListener) {
        this.onGetSingleSmsFailListener = onGetSingleSmsFailListener;
    }

    //封装方法getSingleSmsFailNext
    private void getSingleSmsFailNext() {
        if (onGetSingleSmsFailListener != null) {
            onGetSingleSmsFailListener.getSingleSmsFail();
        }
    }

}
