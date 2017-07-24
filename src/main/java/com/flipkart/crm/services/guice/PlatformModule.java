package com.flipkart.crm.services.guice;


import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import io.dropwizard.hibernate.HibernateBundle;
import org.hibernate.SessionFactory;

/**
 * Created by laxman.muttineni on 11/07/17.
 */
public class PlatformModule extends AbstractModule {

    private final HibernateBundle hibernateBundle;
    public PlatformModule(final HibernateBundle hibernateBundle) {
        this.hibernateBundle = hibernateBundle;
    }

    @Override
    protected void configure() {
        
    }


    @Provides
    public SessionFactory getSessionFactory() {
        return hibernateBundle.getSessionFactory();
    }
}
