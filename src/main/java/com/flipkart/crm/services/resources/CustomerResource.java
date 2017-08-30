package com.flipkart.crm.services.resources;

import com.flipkart.crm.core.controllers.CustomerController;
import com.flipkart.crm.entity.exception.PlatformException;
import com.flipkart.crm.entity.request.CustomerInfoRequest;
import com.flipkart.crm.entity.response.CustomerInfoResponse;
import com.flipkart.crm.entity.session.Session;
import com.flipkart.crm.services.annotations.Secured;
import com.google.inject.Inject;
import io.dropwizard.auth.Auth;
import io.dropwizard.hibernate.UnitOfWork;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by laxman.muttineni on 18/07/17.
 */
@Path("/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Secured
public class CustomerResource {

    private CustomerController customerController;

    @Inject
    public CustomerResource(CustomerController customerController) {
        this.customerController = customerController;
    }

    @GET
    @Path("/test/")
    public String sayHello(@QueryParam("name") String name) {
        return "bigggg";
    }

    @GET
    @Path("/")
    @UnitOfWork
    public CustomerInfoResponse getCustomer(@Auth Session session) throws PlatformException {
        return customerController.getCustomerDetails(session.getAccountId());
    }

    @PUT
    @Path("/")
    @UnitOfWork
    public void createCustomer(CustomerInfoRequest customerInfoRequest) throws Exception {
        customerController.createCustomerDetails(customerInfoRequest);
    }

    @POST
    @Path("/")
    @UnitOfWork
    public void updateCustomer(CustomerInfoRequest customerInfoRequest) throws Exception {
        customerController.updateCustomerDetails(customerInfoRequest);
    }

}
