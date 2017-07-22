package com.flipkart.crm.entity.user;


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
    private String id;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
    private Customer customerId;

    @ManyToOne
    @JoinColumn(name = "instituteId", referencedColumnName = "id", nullable = false)
    private Institute instituteId;

    private DateTime fromDate;

    private DateTime toDate;

    @ManyToOne
    @JoinColumn(name = "degreeId", referencedColumnName = "id", nullable = false)
    private Degree degreeId;

    private Float result;

    public Qualifications() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Institute getInstituteId() {
        return instituteId;
    }

    public void setInstituteId(Institute instituteId) {
        this.instituteId = instituteId;
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

    public Degree getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(Degree degreeId) {
        this.degreeId = degreeId;
    }

    public Float getResult() {
        return result;
    }

    public void setResult(Float result) {
        this.result = result;
    }
}
