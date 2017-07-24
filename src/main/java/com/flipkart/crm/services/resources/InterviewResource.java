package com.flipkart.crm.services.resources;

import com.flipkart.crm.core.controllers.InterviewController;
import com.google.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by laxman.muttineni on 10/07/17.
 */

@Path("/interview")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InterviewResource {

    private InterviewController interviewController;

    @Inject
    public InterviewResource(InterviewController interviewController) {
        this.interviewController = interviewController;
    }

    @POST
    @Path("/")
    public void Customer() throws Exception {
        //return customerController.getCustomerDetails();
    }

}
