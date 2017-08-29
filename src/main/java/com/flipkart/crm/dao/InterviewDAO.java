package com.flipkart.crm.dao;

import com.flipkart.crm.entity.interview.Interview;
import com.flipkart.crm.entity.user.Customer;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import java.util.Optional;

/**
 * Created by laxman.muttineni on 30/07/17.
 */
public class InterviewDAO extends AbstractDAO<Interview> {

    @Inject
    public InterviewDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Interview create(Interview interview) {
        return persist(interview);
    }

    public Interview update(Interview interview) {
        return (interview);
    }

    public Optional<Interview> findById(Integer id) {
        return Optional.ofNullable(get(id));
    }

    public Optional<Customer> findByEmail(String email) {
        return Optional.ofNullable((Customer) currentSession().createCriteria(Customer.class)
                .add(Restrictions.eq("email", email)).uniqueResult());
    }

    public Optional<Customer> findByContact(String contact) {
        return Optional.ofNullable((Customer) currentSession().createCriteria(Customer.class)
                .add(Restrictions.eq("contact", contact)).uniqueResult());
    }

}
