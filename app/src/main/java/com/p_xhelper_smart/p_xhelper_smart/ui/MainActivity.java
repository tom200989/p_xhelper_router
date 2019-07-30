package com.p_xhelper_smart.p_xhelper_smart.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.p_xhelper_smart.p_xhelper_smart.R;
import com.p_xhelper_smart.p_xhelper_smart.core.XSmart;

public class MainActivity extends AppCompatActivity {

    String TAG = "x_ma_qianli";

    @Override
    @SuppressWarnings("unchecked")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.smart_activity_main);
        // 不带返回参数
        XSmart.init(this);
    }
}
