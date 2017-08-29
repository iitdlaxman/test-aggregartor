package com.flipkart.crm.services.resources;

import com.flipkart.crm.core.controllers.InterviewController;
import com.flipkart.crm.entity.interview.Request;
import com.flipkart.crm.entity.response.RequestInterviewResponse;
import com.google.inject.Inject;

import javax.ws.rs.*;
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

    @PUT
    @Path("/")
    public RequestInterviewResponse createRequest(Request request) throws Exception {
        return interviewController.createInterviewRequest(request);
    }

    @DELETE
    @Path("/")
    public void deleteRequest() throws Exception {
        //return customerController.getCustomerDetails();
    }

    /*@DELETE
    @Path("/")
    public void updateRequest() throws Exception {
        //return customerController.getCustomerDetails();
    }*/

    /*@GET
    @Path("/")
    public Request getRequest() throws Exception {
        return interviewController.getInterview("1");
    }*/

    /*@GET
    @Path("/")
    public void getInterview() throws Exception {
        return interviewController.getInterview();
    }*/
}
