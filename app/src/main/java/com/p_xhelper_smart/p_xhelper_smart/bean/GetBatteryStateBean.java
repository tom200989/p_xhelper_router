package com.p_xhelper_smart.p_xhelper_smart.bean;

import java.io.Serializable;

/**
 * Created by wzhiqiang on 2019/7/30
 */
public class GetBatteryStateBean implements Serializable {

    /**
     * chg_state : 1
     * bat_cap : 100
     * bat_level : 4
     * BatteryLevel : 100
     */


    private int chg_state; //0: Charging 1: Charge done 2: Charge remove 3: error occur 4: Charging out for Power Bank
    private int bat_cap;
    private int bat_level;
    private int BatteryLevel;//Min: 1 Max:100

    public static final int CONS_CHARGE_ING = 0;
    public static final int CONS_CHARGE_DONE = 1;
    public static final int CONS_CHARGE_REMOVE = 2;
    public static final int CONS_CHARGE_ERROR = 3;
    public static final int CONS_CHARGE_FOR_POWER_BANK = 4;

    public GetBatteryStateBean() {
    }

    public int getChg_state() {
        return chg_state;
    }

    public void setChg_state(int chg_state) {
        this.chg_state = chg_state;
    }

    public int getBat_cap() {
        return bat_cap;
    }

    public void setBat_cap(int bat_cap) {
        this.bat_cap = bat_cap;
    }

    public int getBat_level() {
        return bat_level;
    }

    public void setBat_level(int bat_level) {
        this.bat_level = bat_level;
    }

    public int getBatteryLevel() {
        return BatteryLevel;
    }

    public void setBatteryLevel(int BatteryLevel) {
        this.BatteryLevel = BatteryLevel;
    }
}
