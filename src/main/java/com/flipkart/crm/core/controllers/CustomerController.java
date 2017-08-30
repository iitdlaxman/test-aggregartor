package com.flipkart.crm.core.controllers;


import com.flipkart.crm.core.factories.CustomerFactory;
import com.flipkart.crm.core.util.Constants;
import com.flipkart.crm.core.util.Validator;
import com.flipkart.crm.dao.CustomerDAO;
import com.flipkart.crm.entity.exception.PlatformException;
import com.flipkart.crm.entity.exception.ResponseCode;
import com.flipkart.crm.entity.request.CustomerInfoRequest;
import com.flipkart.crm.entity.response.CustomerInfoResponse;
import com.flipkart.crm.entity.user.Customer;
import com.flipkart.crm.entity.user.UserIdentifierType;
import com.google.inject.Inject;
import org.eclipse.jetty.http.HttpStatus;

import java.util.Optional;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class CustomerController {

    private CustomerDAO customerDAO;

    @Inject
    public CustomerController(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public CustomerInfoResponse getCustomerDetails(String param) throws PlatformException {
        UserIdentifierType userIdentifierType = Validator.getUserIdentifer(param);
        Optional<Customer> customerOptional = customerDAO.findByRestriction(userIdentifierType.getValue(), param);
        if(!customerOptional.isPresent()) {
            throw new PlatformException(HttpStatus.BAD_REQUEST_400, ResponseCode.CUSTOMER_NOT_EXISTS);
        }
        return CustomerFactory.prepareCustomerInfoResponse(customerOptional.get());
    }

    public void createCustomerDetails(CustomerInfoRequest customerInfoRequest) throws PlatformException {
        //CustomerInfoRequest - additinal data
        String output;
        try {
             customerDAO.create(customerInfoRequest.getCustomer());
        } catch (Exception e) {
            throw new PlatformException(ResponseCode.UNABLE_TO_CREATE_CUSTOMER, e);
        }
    }

    public void updateCustomerDetails(CustomerInfoRequest customerInfoRequest) throws PlatformException {
        String output;
        try {
            customerDAO.update(customerInfoRequest.getCustomer());
        } catch (Exception e) {
            throw new PlatformException(ResponseCode.UNABLE_TO_CREATE_CUSTOMER, e);
        }
    }

    public Optional<Customer> registeredDetails(String param,
                                                String password) throws PlatformException {
        UserIdentifierType userIdentifierType = Validator.getUserIdentifer(param);
        return customerDAO.isRegistered(userIdentifierType.getValue(), param, password);
    }

}
