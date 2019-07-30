package com.p_xhelper_smart.p_xhelper_smart.bean;

import java.io.Serializable;

/*
 * Created by qianli.ma on 2019/7/27 0027.
 */
public class LoginStateBean implements Serializable {

    /**
     * State : 0
     * LoginRemainingTimes : 3
     * LockedRemainingTime : 0
     */

    private int State;// 登陆状态
    private int LoginRemainingTimes;// 登陆剩余次数
    private int LockedRemainingTime;// 锁定剩余时间
    private int PwEncrypt;// 是否需要兼容EE的加密, 1:需要加密; 0:不需要加密

    public LoginStateBean() {
    }

    public int getPwEncrypt() {
        return PwEncrypt;
    }

    public void setPwEncrypt(int pwEncrypt) {
        PwEncrypt = pwEncrypt;
    }

    public int getState() {
        return State;
    }

    public void setState(int State) {
        this.State = State;
    }

    public int getLoginRemainingTimes() {
        return LoginRemainingTimes;
    }

    public void setLoginRemainingTimes(int LoginRemainingTimes) {
        this.LoginRemainingTimes = LoginRemainingTimes;
    }

    public int getLockedRemainingTime() {
        return LockedRemainingTime;
    }

    public void setLockedRemainingTime(int LockedRemainingTime) {
        this.LockedRemainingTime = LockedRemainingTime;
    }
}
