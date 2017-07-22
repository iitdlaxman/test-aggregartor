package com.flipkart.crm.entity;


import com.flipkart.crm.entity.user.Customer;

import javax.persistence.*;

/**
 * Created by laxman.muttineni on 17/07/17.
 */
@Entity
@Table(name="WalletTransactions")
public class WalletTransactions {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
    private Customer fromCustomerId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id", nullable = false)
    private Customer toCustomerId;

    private int type;

    private String reference;

    private String source;

    private String destination;

    public WalletTransactions() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getFromCustomerId() {
        return fromCustomerId;
    }

    public void setFromCustomerId(Customer fromCustomerId) {
        this.fromCustomerId = fromCustomerId;
    }

    public Customer getToCustomerId() {
        return toCustomerId;
    }

    public void setToCustomerId(Customer toCustomerId) {
        this.toCustomerId = toCustomerId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
}
