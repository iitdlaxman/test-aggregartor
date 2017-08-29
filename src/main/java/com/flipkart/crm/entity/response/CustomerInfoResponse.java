package com.flipkart.crm.entity.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flipkart.crm.entity.interview.Interview;
import com.flipkart.crm.entity.interview.Request;
import com.flipkart.crm.entity.user.*;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
