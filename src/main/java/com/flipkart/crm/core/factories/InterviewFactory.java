package com.flipkart.crm.core.factories;

import com.flipkart.crm.entity.interview.Request;
import com.flipkart.crm.entity.response.CustomerInfoResponse;
import com.flipkart.crm.entity.response.RequestInterviewResponse;
import com.flipkart.crm.entity.user.Customer;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class InterviewFactory {

    public static RequestInterviewResponse prepareRequstInfoResponse(Request request) {
        RequestInterviewResponse response = new RequestInterviewResponse();

        response.setCustomerId(request.getCustomerId().getAccountId());
        response.setInterviewType(request.getInterviewType());
        response.setChannel(request.getChannel());
        response.setCount(request.getCount());
        response.setRemaining(request.getRemaining());
        response.setRequestType(request.getRequestType());
        //response.setSlot(request);
        response.setStatus(request.getStatus());
        return response;
    }
}
