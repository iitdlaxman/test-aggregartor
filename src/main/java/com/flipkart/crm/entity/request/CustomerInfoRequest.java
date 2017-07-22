package com.flipkart.crm.entity.request;

import com.flipkart.crm.entity.user.Customer;

/**
 * Created by laxman.muttineni on 14/07/17.
 */
public class CustomerInfoRequest extends BaseRequest {

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
