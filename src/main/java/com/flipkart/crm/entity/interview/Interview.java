package com.flipkart.crm.entity.interview;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.flipkart.crm.entity.user.Channel;
import com.flipkart.crm.entity.user.Customer;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by laxman.muttineni on 17/07/17.
 */
@Entity
@Table(name="Interview")
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    @JsonIgnore
    private int candidateRequestId;

    @JsonIgnore
    private int interviewerRequestId;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime fromTime;

    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime toTime;

    @ManyToOne
    @JoinColumn(name = "channelId", referencedColumnName = "id", nullable = false)
    private Channel channelId;

    @Column(name = "candidateChannelId", nullable = false)
    private String candidateChannelId;

    @Column(name = "interviewerChannelId", nullable = false)
    private String interviewerChannelId;

    @ManyToOne
    @JoinColumn(name = "candidateId", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Customer candidateId;

    //@ManyToOne
    //@JoinColumn(name = "interviewerId", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private String interviewerId;

    private String candidateComments;

    private String interviewerComments;

    public Interview() {
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    @JsonProperty
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonIgnore
    public int getCandidateRequestId() {
        return candidateRequestId;
    }

    @JsonProperty
    public void setCandidateRequestId(int candidateRequestId) {
        this.candidateRequestId = candidateRequestId;
    }

    @JsonIgnore
    public int getInterviewerRequestId() {
        return interviewerRequestId;
    }

    @JsonProperty
    public void setInterviewerRequestId(int interviewerRequestId) {
        this.interviewerRequestId = interviewerRequestId;
    }

    public DateTime getFromTime() {
        return fromTime;
    }

    public void setFromTime(DateTime fromTime) {
        this.fromTime = fromTime;
    }

    public DateTime getToTime() {
        return toTime;
    }

    public void setToTime(DateTime toTime) {
        this.toTime = toTime;
    }

    public Channel getChannelId() {
        return channelId;
    }

    public void setChannelId(Channel channelId) {
        this.channelId = channelId;
    }

    public String getCandidateChannelId() {
        return candidateChannelId;
    }

    public void setCandidateChannelId(String candidateChannelId) {
        this.candidateChannelId = candidateChannelId;
    }

    public String getInterviewerChannelId() {
        return interviewerChannelId;
    }

    public void setInterviewerChannelId(String interviewerChannelId) {
        this.interviewerChannelId = interviewerChannelId;
    }
    @JsonIgnore
    public Customer getCandidateId() {
        return candidateId;
    }
    @JsonProperty
    public void setCandidateId(Customer candidateId) {
        this.candidateId = candidateId;
    }
    @JsonIgnore
    public String getInterviewerId() {
        return interviewerId;
    }
    @JsonProperty
    public void setInterviewerId(String interviewerId) {
        this.interviewerId = interviewerId;
    }

    public String getCandidateComments() {
        return candidateComments;
    }

    public void setCandidateComments(String candidateComments) {
        this.candidateComments = candidateComments;
    }

    public String getInterviewerComments() {
        return interviewerComments;
    }

    public void setInterviewerComments(String interviewerComments) {
        this.interviewerComments = interviewerComments;
    }
}

