package com.flipkart.crm.services.resources;

import com.flipkart.crm.core.controllers.SessionController;
import com.flipkart.crm.entity.exception.PlatformException;
import com.flipkart.crm.entity.exception.ResponseCode;
import com.flipkart.crm.entity.request.LogInRequest;
import com.flipkart.crm.entity.response.LogInResponse;
import com.flipkart.crm.entity.session.Session;
import com.google.common.base.Strings;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by laxman.muttineni on 30/08/17.
 */
@Path("/app")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SessionResource {

    private SessionController sessionController;

    public SessionResource(SessionController sessionController) {
        this.sessionController = sessionController;
    }

    @PUT
    @Path("/login")
    @UnitOfWork
    public LogInResponse logIn(LogInRequest logInRequest) throws Exception {
        if(logInRequest == null || Strings.isNullOrEmpty(logInRequest.getUserName())) {
            throw new PlatformException(ResponseCode.INVALID_CREDENTIALS);
        }
        return sessionController.login(logInRequest);
    }

    @POST
    @Path("/logout")
    @UnitOfWork
    public void logout(@Auth Session session) throws Exception {
        sessionController.logout(session.getToken());
    }

    @POST
    @Path("/logout/all")
    @UnitOfWork
    public void logoutAll(@Auth Session session) throws Exception {
        sessionController.logoutAll(session.getToken());
    }

}
