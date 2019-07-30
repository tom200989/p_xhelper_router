package com.p_xhelper_smart.p_xhelper_smart.utils;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;

/*
 * Created by qianli.ma on 2019/7/25 0025.
 */
public class SmartUtils {

    /**
     * 获取设备类型
     *
     * @param deviceName 当前设备名
     * @return -1:未知设备; 0:老设备; 1:新设备
     */
    public static int getDEVType(String deviceName) {
        // 先最小化
        deviceName = deviceName.toLowerCase();
        // 老设备
        for (String dev : Cons.LIST_DEV_2017) {
            if (deviceName.contains(dev) || dev.contains(deviceName)) {
                return Cons.DEV_2017;
            }
        }
        // 新设备
        for (String dev : Cons.LIST_DEV_2019) {
            if (deviceName.contains(dev) || dev.contains(deviceName)) {
                return Cons.DEV_2019;
            }
        }
        // 定制设备
        for (String dev : Cons.LIST_DEV_TARGET) {
            if (deviceName.contains(dev) || dev.contains(deviceName)) {
                return Cons.DEV_TARGET;
            }
        }
        // 未知设备
        return Cons.DEV_UNKNOWN;
    }

    /**
     * 获取WIFI网管
     *
     * @param context 域
     * @return 网关, 如192.168.1.1
     */
    public static String getWIFIGateWay(Context context) {
        WifiManager wifi = (WifiManager) context.getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        DhcpInfo dhcp = wifi.getDhcpInfo();
        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf((dhcp.gateway & 0xff))).append(".");
        builder.append(String.valueOf(((dhcp.gateway >> 8) & 0xff))).append(".");
        builder.append(String.valueOf(((dhcp.gateway >> 16) & 0xff))).append(".");
        builder.append(String.valueOf(((dhcp.gateway >> 24) & 0xff)));
        return builder.toString();
    }
}
