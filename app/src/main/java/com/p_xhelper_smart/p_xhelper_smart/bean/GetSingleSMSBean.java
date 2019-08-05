package com.p_xhelper_smart.p_xhelper_smart.bean;

import java.io.Serializable;

/**
 * Created by wzhiqiang on 2019/7/31
 */
public class GetSingleSMSBean implements Serializable {


    /**
     * PhoneNumber : 13713804698
     * SMSType : 0
     * SMSContent : Hello World
     * SMSId : 3
     * SMSTime : 2014-01-12 11:06:58
     */

    private String PhoneNumber;//电话号码
    private int SMSType;//短信类型，如下常量
    private String SMSContent;//短信内容
    private String SMSId;//短信id
    private String SMSTime;//发送短信时间

    public static final int CONS_SMS_TYPE_READ = 0;
    public static final int CONS_SMS_TYPE_UNREAD = 1;
    public static final int CONS_SMS_TYPE_SENT = 2;
    public static final int CONS_SMS_TYPE_SENT_FAIL = 3;
    public static final int CONS_SMS_TYPE_REPORT = 4;
    public static final int CONS_SMS_TYPE_FLASH = 5;
    public static final int CONS_SMS_TYPE_DRAFT = 6;
    public GetSingleSMSBean() {
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public int getSMSType() {
        return SMSType;
    }

    public void setSMSType(int SMSType) {
        this.SMSType = SMSType;
    }

    public String getSMSContent() {
        return SMSContent;
    }

    public void setSMSContent(String SMSContent) {
        this.SMSContent = SMSContent;
    }

    public String getSMSId() {
        return SMSId;
    }

    public void setSMSId(String SMSId) {
        this.SMSId = SMSId;
    }

    public String getSMSTime() {
        return SMSTime;
    }

    public void setSMSTime(String SMSTime) {
        this.SMSTime = SMSTime;
    }
}
