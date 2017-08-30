package com.flipkart.crm.entity.session;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by laxman.muttineni on 30/08/17.
 */
@Entity
@Table(name="Session")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;
    private String accountId;
    private String token;

    @Enumerated(EnumType.STRING)
    private SessionStatus status;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime creationTime;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime updatedTime;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime expiryTime;


    public Session() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public SessionStatus getStatus() {
        return status;
    }

    public void setStatus(SessionStatus status) {
        this.status = status;
    }

    public DateTime getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(DateTime creationTime) {
        this.creationTime = creationTime;
    }

    public DateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(DateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public DateTime getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(DateTime expiryTime) {
        this.expiryTime = expiryTime;
    }
}
