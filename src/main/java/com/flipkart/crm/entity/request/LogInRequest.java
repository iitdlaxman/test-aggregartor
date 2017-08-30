package com.flipkart.crm.entity.request;

/**
 * Created by laxman.muttineni on 30/08/17.
 */
public class LogInRequest {

    private String userName;

    private String password;

    public LogInRequest() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
