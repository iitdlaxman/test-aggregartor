package com.flipkart.crm.entity.interview;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flipkart.crm.entity.user.Customer;
import com.flipkart.crm.entity.user.Skill;

import javax.persistence.*;

/**
 * Created by laxman.muttineni on 28/07/17.
 */
@Entity
@Table(name="InterviewRating")
public class InterviewRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "interviewId", referencedColumnName = "id", nullable = false)
    private Interview interview;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "skillId", referencedColumnName = "id", nullable = false)
    private Skill skill;

    @Column(name = "rating", nullable = false)
    private Float rating;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Interview getInterview() {
        return interview;
    }

    public void setInterview(Interview interview) {
        this.interview = interview;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }
}
