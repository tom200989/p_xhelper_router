package com.p_xhelper_smart.p_xhelper_smart.bean;

/*
 * Created by qianli.ma on 2019/7/29 0029.
 */
public class LoginParam {

    /**
     * UserName : admin
     * Password : admin
     */

    private String UserName;
    private String Password;

    public LoginParam() {
    }

    public LoginParam(String userName, String password) {
        UserName = userName;
        Password = password;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
