package com.flipkart.crm.entity.interview;


import com.flipkart.crm.entity.user.Channel;
import com.flipkart.crm.entity.user.Customer;
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
    private String id;

    private int candidateRequestId;

    private int interviewerRequestId;

    private DateTime fromTime;

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
    private Customer candidateId;

    @ManyToOne
    @JoinColumn(name = "interviewerId", referencedColumnName = "id", nullable = false)
    private Customer interviewerId;

    private String candidateComments;

    private String interviewerComments;

    public Interview() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCandidateRequestId() {
        return candidateRequestId;
    }

    public void setCandidateRequestId(int candidateRequestId) {
        this.candidateRequestId = candidateRequestId;
    }

    public int getInterviewerRequestId() {
        return interviewerRequestId;
    }

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

    public Customer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Customer candidateId) {
        this.candidateId = candidateId;
    }

    public Customer getInterviewerId() {
        return interviewerId;
    }

    public void setInterviewerId(Customer interviewerId) {
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

