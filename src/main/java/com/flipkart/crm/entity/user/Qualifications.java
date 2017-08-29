package com.flipkart.crm.entity.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by laxman.muttineni on 17/07/17.
 */
@Entity
@Table(name="Qualifications")
public class Qualifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private String id;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "instituteId", referencedColumnName = "id", nullable = false)
    private Institute institute;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime fromDate;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime toDate;

    @ManyToOne
    @JoinColumn(name = "degreeId", referencedColumnName = "id", nullable = false)
    private Degree degree;

    private Float result;

    public Qualifications() {
    }

    @JsonIgnore
    public String getId() {
        return id;
    }

    @JsonProperty
    public void setId(String id) {
        this.id = id;
    }

    @JsonIgnore
    public Customer getCustomerId() {
        return customerId;
    }

    @JsonProperty
    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Institute getInstitute() {
        return institute;
    }

    public void setInstitute(Institute institute) {
        this.institute = institute;
    }

    public DateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(DateTime fromDate) {
        this.fromDate = fromDate;
    }

    public DateTime getToDate() {
        return toDate;
    }

    public void setToDate(DateTime toDate) {
        this.toDate = toDate;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Float getResult() {
        return result;
    }

    public void setResult(Float result) {
        this.result = result;
    }
}
