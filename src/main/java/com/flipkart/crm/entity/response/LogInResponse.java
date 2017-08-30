package com.flipkart.crm.entity.response;

import org.joda.time.DateTime;

/**
 * Created by laxman.muttineni on 30/08/17.
 */
public class LogInResponse extends BaseResponse {

    private String token;

    private DateTime expiryTime;

    public LogInResponse() {
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public DateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(DateTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}
