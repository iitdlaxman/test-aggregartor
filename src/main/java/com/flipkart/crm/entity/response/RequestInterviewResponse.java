package com.flipkart.crm.entity.response;

import com.flipkart.crm.entity.interview.Interview;
import com.flipkart.crm.entity.interview.InterviewType;
import com.flipkart.crm.entity.interview.RequestStatus;
import com.flipkart.crm.entity.interview.RequestType;
import com.flipkart.crm.entity.user.Channel;
import com.flipkart.crm.entity.user.Customer;

/**
 * Created by laxman.muttineni on 04/08/17.
 */
public class RequestInterviewResponse extends BaseResponse {

    private String customerId;

    private RequestType requestType;

    private RequestStatus status;

    private InterviewType interviewType;

    private Integer count;

    private Integer remaining;

    private Channel channel;

    private String slot;

    public RequestInterviewResponse() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public InterviewType getInterviewType() {
        return interviewType;
    }

    public void setInterviewType(InterviewType interviewType) {
        this.interviewType = interviewType;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getRemaining() {
        return remaining;
    }

    public void setRemaining(Integer remaining) {
        this.remaining = remaining;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}
