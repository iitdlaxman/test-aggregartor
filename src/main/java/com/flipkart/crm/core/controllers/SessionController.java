package com.flipkart.crm.core.controllers;

import com.flipkart.crm.core.factories.CustomerFactory;
import com.flipkart.crm.core.factories.SessionFactory;
import com.flipkart.crm.core.util.Constants;
import com.flipkart.crm.dao.SessionDAO;
import com.flipkart.crm.entity.exception.PlatformException;
import com.flipkart.crm.entity.exception.ResponseCode;
import com.flipkart.crm.entity.request.LogInRequest;
import com.flipkart.crm.entity.response.LogInResponse;
import com.flipkart.crm.entity.session.Session;
import com.flipkart.crm.entity.session.SessionStatus;
import com.flipkart.crm.entity.user.Customer;
import com.google.inject.Inject;
import org.eclipse.jetty.http.HttpStatus;
import org.joda.time.DateTime;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by laxman.muttineni on 30/08/17.
 */
public class SessionController {

    private SessionDAO sessionDAO;
    private CustomerController customerController;

    @Inject
    public SessionController(SessionDAO sessionDAO,
                             CustomerController customerController) {
        this.sessionDAO = sessionDAO;
        this.customerController = customerController;
    }

    public LogInResponse login(LogInRequest request) throws PlatformException {

        Optional<Customer> customerOptional =
                customerController.registeredDetails(request.getUserName(), request.getPassword());
        if (!customerOptional.isPresent()) {
            throw new PlatformException(HttpStatus.BAD_REQUEST_400, ResponseCode.CUSTOMER_NOT_EXISTS);
        }
        Session session = new Session();
        Customer customer = customerOptional.get();
        session.setAccountId(customer.getAccountId());
        session.setCreationTime(DateTime.now());
        session.setUpdatedTime(DateTime.now());
        session.setToken(UUID.randomUUID().toString());
        session.setStatus(SessionStatus.ACTIVE);
        session.setExpiryTime(session.getUpdatedTime().plusHours(Constants.SESSION_EXPIRY_HOURS));

        Optional<List<Session>> activeCxSessions = sessionDAO.findByAccountId(customer.getAccountId());
        if (activeCxSessions.isPresent() && activeCxSessions.get().size() >= Constants.MAX_SESSION_LIMITS) {
            throw new PlatformException(HttpStatus.BAD_REQUEST_400, ResponseCode.SESSION_LIMIT_EXPIRED);
        }
        sessionDAO.create(session);
        return SessionFactory.prepareCustomerInfoResponse(session);
    }

    public void logout(String token) throws PlatformException {
        sessionDAO.deActiveSession(token);
    }

    public void logoutAll(String accountid) throws PlatformException {
        sessionDAO.deActiveSessions(accountid);
    }

}
