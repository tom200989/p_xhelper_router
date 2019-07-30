package com.p_xhelper_smart.p_xhelper_smart.bean;

import java.io.Serializable;

/*
 * Created by qianli.ma on 2019/7/29 0029.
 */
public class SystemInfoBean implements Serializable {

    /**
     * SwVersion : HH70_IA_02.00_10
     * HwVersion : HH70-V-V1.0
     * WebUiVersion : HH70_JRDRESOURCE_IA_05_2078
     * HttpApiVersion : TCL-HTTP
     * AppVersion : V1.0
     * DeviceName : HH70
     * IMEI : 869486010150315
     * sn :
     * MacAddress : 8c:dc:d4:31:ba:b5
     * IMSI : 460010322682758
     * ICCID : 89860116851018021319
     * MsisdnMark : 1
     * MSISDN : 8618620322862
     * SwVersionMain : HH70_IA_02.00_10
     * MacAddress5G : 85:55:55:31:ba:b5
     */

    private String SwVersion;// 软件版本
    private String HwVersion;// 硬件版本
    private String WebUiVersion;// WEB版本
    private String HttpApiVersion;// API版本
    private String AppVersion;// APP版本
    private String DeviceName;// 设备名
    private String IMEI;// IMEI号
    private String sn;// SN号
    private String MacAddress;// MAC地址
    private String IMSI;// IMSI号
    private String ICCID;// ICCID号
    private int MsisdnMark;// MARK号
    private String MSISDN;// MSISDN号
    private String SwVersionMain;// 主板软件版本
    private String MacAddress5G;// 5G MAC地址

    public SystemInfoBean() {
    }

    public String getSwVersion() {
        return SwVersion;
    }

    public void setSwVersion(String SwVersion) {
        this.SwVersion = SwVersion;
    }

    public String getHwVersion() {
        return HwVersion;
    }

    public void setHwVersion(String HwVersion) {
        this.HwVersion = HwVersion;
    }

    public String getWebUiVersion() {
        return WebUiVersion;
    }

    public void setWebUiVersion(String WebUiVersion) {
        this.WebUiVersion = WebUiVersion;
    }

    public String getHttpApiVersion() {
        return HttpApiVersion;
    }

    public void setHttpApiVersion(String HttpApiVersion) {
        this.HttpApiVersion = HttpApiVersion;
    }

    public String getAppVersion() {
        return AppVersion;
    }

    public void setAppVersion(String AppVersion) {
        this.AppVersion = AppVersion;
    }

    public String getDeviceName() {
        return DeviceName;
    }

    public void setDeviceName(String DeviceName) {
        this.DeviceName = DeviceName;
    }

    public String getIMEI() {
        return IMEI;
    }

    public void setIMEI(String IMEI) {
        this.IMEI = IMEI;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getMacAddress() {
        return MacAddress;
    }

    public void setMacAddress(String MacAddress) {
        this.MacAddress = MacAddress;
    }

    public String getIMSI() {
        return IMSI;
    }

    public void setIMSI(String IMSI) {
        this.IMSI = IMSI;
    }

    public String getICCID() {
        return ICCID;
    }

    public void setICCID(String ICCID) {
        this.ICCID = ICCID;
    }

    public int getMsisdnMark() {
        return MsisdnMark;
    }

    public void setMsisdnMark(int MsisdnMark) {
        this.MsisdnMark = MsisdnMark;
    }

    public String getMSISDN() {
        return MSISDN;
    }

    public void setMSISDN(String MSISDN) {
        this.MSISDN = MSISDN;
    }

    public String getSwVersionMain() {
        return SwVersionMain;
    }

    public void setSwVersionMain(String SwVersionMain) {
        this.SwVersionMain = SwVersionMain;
    }

    public String getMacAddress5G() {
        return MacAddress5G;
    }

    public void setMacAddress5G(String MacAddress5G) {
        this.MacAddress5G = MacAddress5G;
    }
}
