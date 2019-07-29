package com.p_xhelper_smart.p_xhelper_smart.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.p_xhelper_smart.p_xhelper_smart.R;
import com.p_xhelper_smart.p_xhelper_smart.bean.LoginStateBean;
import com.p_xhelper_smart.p_xhelper_smart.core.XSmart;
import com.p_xhelper_smart.p_xhelper_smart.impl.FwError;
import com.p_xhelper_smart.p_xhelper_smart.impl.XNormalCallback;

public class MainActivity extends AppCompatActivity {

    String TAG = "x_ma_qianli";

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart_activity_main);
        // 不带返回参数
        XSmart.init(this);
        XSmart<LoginStateBean> xSmart = new XSmart<>();
        xSmart.xMethod("GetLoginState");
        xSmart.xPost(new XNormalCallback<LoginStateBean>() {
            @Override
            public void success(LoginStateBean stateBean) {
                Log.i(TAG, "getState: " + stateBean.getState());
                Log.i(TAG, "getLockedRemainingTime: " + stateBean.getLockedRemainingTime());
                Log.i(TAG, "getLoginRemainingTimes: " + stateBean.getLoginRemainingTimes());
                Log.i(TAG, "getPwEncrypt: " + stateBean.getPwEncrypt());
            }

            @Override
            public void appError(Throwable ex) {
                Log.e(TAG, "ex: " + ex.getMessage());
            }

            @Override
            public void fwError(FwError fwError) {
                Log.e(TAG, "code: " + fwError.getCode() + "; msg: " + fwError.getMessage());
            }
        });
        
        XSmart smart = new XSmart<>();
        smart.xPost(new XNormalCallback() {
            @Override
            public void success(Object result) {
                
            }

            @Override
            public void appError(Throwable ex) {

            }

            @Override
            public void fwError(FwError fwError) {

            }
        });
    }
}
