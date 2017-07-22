package com.flipkart.crm.entity.response;

import com.flipkart.crm.entity.Attribute;
import com.flipkart.crm.entity.user.Customer;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class CustomerInfoResponse extends BaseResponse {

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
