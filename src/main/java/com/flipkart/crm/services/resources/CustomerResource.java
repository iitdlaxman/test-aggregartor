package com.flipkart.crm.services.resources;

import com.flipkart.crm.core.controllers.CustomerController;
import com.flipkart.crm.entity.exception.PlatformException;
import com.flipkart.crm.entity.request.CustomerInfoRequest;
import com.flipkart.crm.entity.response.CustomerInfoResponse;
import com.flipkart.crm.services.annotations.Secured;
//import com.google.inject.Inject;

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

    //@Inject
    public CustomerResource(String template,
                            CustomerController customerController) {
        this.customerController = customerController;
    }

    @GET
    @Path("/test/")
    public String sayHello(@QueryParam("name") String name) {
        /*Map<String, String> result = new HashMap<String, String>();
        result.put("hello", String.format(template, name.orElse("stranger")));*/
        return "bigggg";
    }

    @GET
    @Path("/")
    public CustomerInfoResponse getCustomer(Integer customerId) throws PlatformException { //todo : move to session
        return customerController.getCustomerDetails(customerId);
    }

    @PUT
    @Path("/")
    public void createCustomer(CustomerInfoRequest customerInfoRequest) throws Exception {
        customerController.createCustomerDetails(customerInfoRequest);
    }

    /*@GET
    @Path("/")
    public CustomerInfoResponse getCustomer() throws PlatformException {
        return customerController.getCustomerDetails();
    }

    @POST
    @Path("/")
    public CustomerInfoResponse updateCustomer() throws Exception {
        return customerController.getCustomerDetails();
    }

    @POST
    @Path("/validate")
    public void validateCustomer() throws Exception {
        customerController.getCustomerDetails();
    }*/
}
