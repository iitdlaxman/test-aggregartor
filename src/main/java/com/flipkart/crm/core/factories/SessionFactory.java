package com.flipkart.crm.core.factories;

import com.flipkart.crm.entity.response.LogInResponse;
import com.flipkart.crm.entity.session.Session;

/**
 * Created by laxman.muttineni on 30/08/17.
 */
public class SessionFactory {

    public static LogInResponse prepareCustomerInfoResponse(Session session) {
        LogInResponse logInResponse = new LogInResponse();
        logInResponse.setToken(session.getToken());
        logInResponse.setExpiryTime(session.getCreationTime());
        return logInResponse;
    }
}
