package com.p_xhelper_smart.p_xhelper_smart.bean;

import java.io.Serializable;

/**
 * Created by wzhiqiang on 2019/8/2
 */
public class GetSingleSMSParam implements Serializable {

    /**
     * SMSId : 65538
     */

    private int SMSId;

    public GetSingleSMSParam() {
    }

    public GetSingleSMSParam(int SMSId) {
        this.SMSId = SMSId;
    }

    public int getSMSId() {
        return SMSId;
    }

    public void setSMSId(int SMSId) {
        this.SMSId = SMSId;
    }
}
