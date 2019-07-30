package com.p_xhelper_smart.p_xhelper_smart.utils;

import android.annotation.SuppressLint;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by qianli.ma on 2019/7/25 0025.
 */
@SuppressLint("UseSparseArrays")
public class Cons {

    public static String TAG = "xsmart";

    public static int DEV_UNKNOWN = -1;// 未知设备
    public static int DEV_2017 = 0;// 老设备
    public static int DEV_2019 = 1;// 新设备
    public static int DEV_TARGET = 2;// 定制设备

    public static List<String> LIST_DEV_2017 = new ArrayList<>();
    public static List<String> LIST_DEV_2019 = new ArrayList<>();
    public static List<String> LIST_DEV_TARGET = new ArrayList<>();

    static {
        // 老设备类型
        LIST_DEV_2017.add("hh70");
        LIST_DEV_2017.add("hub70");
        LIST_DEV_2017.add("hh40");
        LIST_DEV_2017.add("hub40");
        LIST_DEV_2017.add("hh41");
        LIST_DEV_2017.add("hub41");
        // 新设备类型
        LIST_DEV_2019.add("hub71");
        LIST_DEV_2019.add("mw12");
        LIST_DEV_2019.add("mw70");
        // 定制设备
        LIST_DEV_TARGET.add("E1");
    }

    // 方法
    public static String METHOD_LOGIN = "Login";
    public static String METHOD_LOGOUT = "Logout";
    public static String METHOD_GET_LOGIN_STATE = "GetLoginState";
    public static String METHOD_CHANGE_PASSWORD = "ChangePassword";
    public static String METHOD_HEART_BEAT = "HeartBeat";
    public static String METHOD_SET_PASSWORD_CHANGE_FLAG = "SetPasswordChangeFlag";
    public static String METHOD_GET_PASSWORD_CHANGE_FLAG = "GetPasswordChangeFlag";
    public static String METHOD_GET_CURRENT_LANGUAGE = "GetCurrentLanguage";
    public static String METHOD_GET_SMS_STORAGE_STATE = "GetSMSStorageState";
    public static String METHOD_SEARCH_NETWORK_RESULT = "SearchNetworkResult";
    public static String METHOD_GET_NETWORK_REGISTER_STATE = "GetNetworkRegisterState";
    public static String METHOD_GET_SIM_STATUS = "GetSimStatus";
    public static String METHOD_UNLOCK_PIN = "UnlockPin";
    public static String METHOD_UNLOCK_PUK = "UnlockPuk";
    public static String METHOD_CHANGE_PIN_CODE = "ChangePinCode";
    public static String METHOD_CHANGE_PIN_STATE = "ChangePinState";
    public static String METHOD_GET_AUTO_VALIDATE_PIN_STATE = "GetAutoValidatePinState";
    public static String METHOD_SET_AUTO_VALIDATE_PIN_STATE = "SetAutoValidatePinState";
    public static String METHOD_UNLOCK_SIMLOCK = "UnlockSimlock";
    public static String METHOD_GET_CONNECTION_STATE = "GetConnectionState";
    public static String METHOD_CONNECT = "Connect";
    public static String METHOD_DISCONNECT = "DisConnect";
    public static String METHOD_GET_CONNECTION_SETTINGS = "GetConnectionSettings";
    public static String METHOD_SET_CONNECTION_SETTINGS = "SetConnectionSettings";
    public static String METHOD_SET_CONNECTION_MODE = "SetConnectionMode";
    public static String METHOD_GET_NETWORK_SETTINGS = "GetNetworkSettings";
    public static String METHOD_SET_NETWORK_SETTINGS = "SetNetworkSettings";
    public static String METHOD_GET_NETWORK_INFO = "GetNetworkInfo";
    public static String METHOD_GET_WLAN_STATE = "GetWlanState";
    public static String METHOD_SET_WLAN_STATE = "SetWlanState";
    public static String METHOD_SET_WLAN_ON = "SetWlanOn";
    public static String METHOD_GET_WLAN_SETTINGS = "GetWlanSettings";
    public static String METHOD_SET_WLAN_SETTINGS = "SetWlanSettings";
    public static String METHOD_SET_WPS_PIN = "SetWPSPin";
    public static String METHOD_SET_WPS_PBC = "SetWPSPbc";
    public static String METHOD_GET_WLAN_SUPPORT_MODE = "GetWlanSupportMode";
    public static String METHOD_GET_WLAN_STATISTICS = "GetWlanStatistics";
    public static String METHOD_GET_SYSTEM_STATUS = "GetSystemStatus";
    public static String METHOD_GET_SYSTEM_INFO = "GetSystemInfo";
    public static String METHOD_SET_DEVICE_REBOOT = "SetDeviceReboot";
    public static String METHOD_SET_DEVICE_RESET = "SetDeviceReset";
    public static String METHOD_SET_DEVICE_BACKUP = "SetDeviceBackup";
    public static String METHOD_GET_WAN_SETTINGS = "GetWanSettings";
    public static String METHOD_SET_WAN_SETTINGS = "SetWanSettings";
    public static String METHOD_GET_LAN_SETTINGS = "GetLanSettings";
    public static String METHOD_GET_DEVICE_NEW_VERSION = "GetDeviceNewVersion";
    public static String METHOD_SET_CHECK_NEW_VERSION = "SetCheckNewVersion";
    public static String METHOD_SET_DEVICE_START_UPDATE = "SetDeviceStartUpdate";
    public static String METHOD_GET_DEVICE_UPGRADE_STATE = "GetDeviceUpgradeState";
    public static String METHOD_SET_FOTA_START_DOWNLOAD = "SetFOTAStartDownload";
    public static String METHOD_SET_DEVICE_UPDATE_STOP = "SetDeviceUpdateStop";
    public static String METHOD_GET_FTP_SETTINGS = "GetFtpSettings";
    public static String METHOD_GET_SAMBA_SETTINGS = "GetSambaSettings";
    public static String METHOD_GET_DLNA_SETTINGS = "GetDLNASettings";
    public static String METHOD_SET_FTP_SETTINGS = "SetFtpSettings";
    public static String METHOD_SET_SAMBA_SETTINGS = "SetSambaSettings";
    public static String METHOD_SET_DLNA_SETTINGS = "SetDLNASettings";
    public static String METHOD_GET_BATTERYSTATE = "GetBatteryState";
    public static String METHOD_GET_NETWORKINFO = "GetNetworkInfo";
    public static String METHOD_SET_USAGE_SETTING = "SetUsageSettings";
    public static String METHOD_GET_USAGESETTING = "GetUsageSettings";
    public static String METHOD_GET_USAGERECORD = "GetUsageRecord";
    public static String METHOD_SET_USAGERECORDCLEAR = "SetUsageRecordClear";
    public static String METHOD_GET_CONNECTEDDEVICELIST = "GetConnectedDeviceList";
    public static String METHOD_GET_BLOCKDEVICELIST = "GetBlockDeviceList";
    public static String METHOD_SET_CONNECTEDDEVICEBLOCK = "SetConnectedDeviceBlock";
    public static String METHOD_SET_DEVICEUNBLOCK = "SetDeviceUnblock";
    public static String METHOD_SET_DEVICENAME = "SetDeviceName";
    public static String METHOD_GET_PROFILE_LIST = "GetProfileList";
    public static String METHOD_GET_SMSCONTACTLIST = "GetSMSContactList";
    public static String METHOD_GET_SMSINITSTATE = "getSmsInitState";
    public static String METHOD_GET_SMSCONTENTLIST = "GetSMSContentList";
    public static String METHOD_SAVESMS = "SaveSMS";
    public static String METHOD_DELETESMS = "DeleteSMS";
    public static String METHOD_SENDSMS = "SendSMS";
    public static String METHOD_GET_SEND_SMS_RESULT = "GetSendSMSResult";
    public static String METHOD_GET_SINGLE_SMS = "GetSingleSMS";
    public static String METHOD_GET_WIFI_EXTENDER_SETTINGS = "GetWIFIExtenderSettings";
    public static String METHOD_SET_WIFI_EXTENDER_SETTINGS = "SetWIFIExtenderSettings";
    public static String METHOD_GET_WIFI_EXTENDER_CURRENT_STATUS = "GetWIFIExtenderCurrentStatus";
    public static String METHOD_GET_HOTSPOT_LIST = "GetHotspotList";
    public static String METHOD_SEARCH_HOTSPOT = "SearchHotspot";
    public static String METHOD_CONNECT_HOTSPOT = "ConnectHotspot";
    public static String METHOD_GET_CONNECT_HOTSPOT_STATE = "GetConnectHotspotState";
    public static String METHOD_DISCONNECT_HOTSPOT = "DisConnectHotspot";

    public static int CONS_PWENCRYPT_ON = 1;// 需加密状态
    public static int CONS_PWENCRYPT_OFF = 0;// 无需加密状态
    public static int CONS_LOGOUT = 0;// 登出
    public static int CONS_LOGIN = 1;// 登陆
    public static int CONS_LOGIN_TIME_USER_OUT = 2;// 登陆次数用尽
}
