package com.flipkart.crm.dao;

import com.flipkart.crm.entity.user.Customer;
import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import java.util.Optional;


/**
 * Created by Vikram Aditya on 6/23/2017.
 */
public class CustomerDAO extends AbstractDAO<Customer> {

    @Inject
    public CustomerDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Customer create(Customer customer) {
        return persist(customer);
    }

    public Customer update(Customer customer) {
        return (customer);
    }

    public Optional<Customer> findById(Integer id) {
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
