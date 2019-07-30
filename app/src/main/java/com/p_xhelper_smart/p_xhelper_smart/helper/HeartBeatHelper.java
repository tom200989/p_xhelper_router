package com.p_xhelper_smart.p_xhelper_smart.helper;

import com.p_xhelper_smart.p_xhelper_smart.core.XSmart;
import com.p_xhelper_smart.p_xhelper_smart.impl.FwError;
import com.p_xhelper_smart.p_xhelper_smart.impl.XNormalCallback;
import com.p_xhelper_smart.p_xhelper_smart.utils.Cons;
import com.p_xhelper_smart.p_xhelper_smart.utils.Logg;

/*
 * Created by qianli.ma on 2019/7/30 0030.
 */
@SuppressWarnings("unchecked")
public class HeartBeatHelper extends BaseHelper {

    /**
     * 心跳
     */
    public void heartbeat() {
        XSmart xHeartbeat = new XSmart();
        xHeartbeat.xMethod(Cons.METHOD_HEART_BEAT).xPost(new XNormalCallback() {
            @Override
            public void success(Object result) {
                Logg.t(Cons.TAG).ww("--> heart beat success! -->");
            }

            @Override
            public void appError(Throwable ex) {
                Logg.t(Cons.TAG).ww("--> heart beat app error! -->");
            }

            @Override
            public void fwError(FwError fwError) {
                Logg.t(Cons.TAG).ww("--> heart beat fw error! -->");
            }

            @Override
            public void finish() {

            }
        });
    }
}
