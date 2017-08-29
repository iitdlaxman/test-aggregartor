package com.flipkart.crm.dao;

import com.flipkart.crm.entity.interview.Interview;
import com.flipkart.crm.entity.interview.Request;
import com.flipkart.crm.entity.user.Customer;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.Optional;

/**
 * Created by laxman.muttineni on 04/08/17.
 */
public class RequestDAO extends AbstractDAO<Request> {

    @Inject
    public RequestDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Request create(Request request) {
        return persist(request);
    }

    public Interview update(Interview interview) {
        return (interview);
    }

    public Optional<Request> findById(Integer id) {
        return Optional.ofNullable(get(id));
    }

}
