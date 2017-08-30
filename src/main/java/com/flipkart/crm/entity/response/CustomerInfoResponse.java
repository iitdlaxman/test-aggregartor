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
   /* private String accountId;
    private String firstName;
    private String lastName;
    private String contact;
    private DateTime dateOfJoining;
    private String email;
    private String role;
    private String location;
    private String company;
    private String status;
    private Integer balance;
    private Set<Attribute> attributes;
    private List<SkillRating> skillRatings;
    private List<CXRating> cxRatings;
    private List<Interview> candidature;
    private List<Interview> interviews;
    private List<Request> requests;
    private List<Qualifications> qualifications;*/

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
