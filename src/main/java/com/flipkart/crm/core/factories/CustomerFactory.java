package com.flipkart.crm.core.factories;

import com.flipkart.crm.entity.response.CustomerInfoResponse;
import com.flipkart.crm.entity.user.Customer;
/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class CustomerFactory {

    public static CustomerInfoResponse prepareCustomerInfoResponse(Customer customer) {
        CustomerInfoResponse customerResponse = new CustomerInfoResponse();
       /* customerResponse.setFirstName(customer.getFirstName());
        customerResponse.setLastName(customer.getLastName());
        customerResponse.setEmail(customer.getEmail());
        customerResponse.setContact(customer.getContact());
        customerResponse.setDateOfJoining(customer.getDateOfJoining());
        customerResponse.setStatus(customer.getStatus());
        customerResponse.setAttributes(customer.getAttributes());
        if(customer.getCompany() != null) {
            customerResponse.setCompany(customer.getCompany().getName());
        }
        if(customer.getLocation() != null) {
            customerResponse.setLocation(customer.getLocation().getName());
        }
        if(customer.getRole() != null) {
            customerResponse.setRole(customer.getRole().getTitle());
        }*/
        customerResponse.setCustomer(customer);
        return customerResponse;
    }
}
