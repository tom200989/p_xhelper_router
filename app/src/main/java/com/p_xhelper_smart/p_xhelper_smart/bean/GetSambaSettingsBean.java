package com.p_xhelper_smart.p_xhelper_smart.bean;

import java.io.Serializable;

/*
 * Created by qianli.ma on 2019/8/1 0001.
 */
public class GetSambaSettingsBean implements Serializable {
    /**
     * SambaStatus : 1
     * Anonymous : 0
     * AuthType : 0
     */

    private int SambaStatus;
    private int Anonymous;
    private int AuthType;

    public static int SAMBASTATUS_DISABLE = 0;
    public static int SAMBASTATUS_ENABLE = 1;

    public static int ANONYMOUS_DISABLE = 0;
    public static int ANONYMOUS_ENABLE = 1;

    public static int READONLY = 0;
    public static int READWRITE = 1;

    public GetSambaSettingsBean() {
    }

    public int getSambaStatus() {
        return SambaStatus;
    }

    public void setSambaStatus(int SambaStatus) {
        this.SambaStatus = SambaStatus;
    }

    public int getAnonymous() {
        return Anonymous;
    }

    public void setAnonymous(int Anonymous) {
        this.Anonymous = Anonymous;
    }

    public int getAuthType() {
        return AuthType;
    }

    public void setAuthType(int AuthType) {
        this.AuthType = AuthType;
    }
}
