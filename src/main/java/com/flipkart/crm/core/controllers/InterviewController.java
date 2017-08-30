package com.flipkart.crm.core.controllers;

import com.flipkart.crm.core.factories.InterviewFactory;
import com.flipkart.crm.dao.RequestDAO;
import com.flipkart.crm.entity.interview.Interview;
import com.flipkart.crm.entity.interview.Request;
import com.flipkart.crm.entity.interview.RequestStatus;
import com.flipkart.crm.entity.response.RequestInterviewResponse;
import com.google.inject.Inject;

/**
 * Created by laxman.muttineni on 10/07/17.
 */
public class InterviewController {

    private RequestDAO requestDAO;

    @Inject
    public InterviewController(RequestDAO requestDAO) {
        this.requestDAO = requestDAO;
    }

    public Interview getInterview(String accountId) {
        return new Interview();
    }

    public RequestInterviewResponse createInterviewRequest(Request request) {
        //request.setCustomerId();
        request.setStatus(RequestStatus.REQUESTED);
        request.setRemaining(request.getCount());
        Request createdRequest = requestDAO.create(request);
        return InterviewFactory.prepareRequstInfoResponse(createdRequest);
    }

}
