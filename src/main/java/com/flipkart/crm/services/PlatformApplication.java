package com.flipkart.crm.services;

import com.flipkart.crm.dao.SessionDAO;
import com.flipkart.crm.entity.interview.*;
import com.flipkart.crm.entity.session.Session;
import com.flipkart.crm.entity.user.*;
import com.flipkart.crm.services.auth.SessionAuthenticator;
import com.flipkart.crm.services.configuration.PlatformConfiguration;
import com.flipkart.crm.services.healthCheck.AppInRotationHealthCheck;
import com.flipkart.crm.services.guice.PlatformModule;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.netflix.governator.guice.LifecycleInjector;
import io.dropwizard.Application;
import io.dropwizard.auth.AuthFactory;
import io.dropwizard.auth.basic.BasicAuthFactory;
import io.dropwizard.auth.oauth.OAuthFactory;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Created by laxman.muttineni on 18/07/17.
 */
public class PlatformApplication extends Application<PlatformConfiguration> {

    private final HibernateBundle<PlatformConfiguration> hibernateBundle = new HibernateBundle<PlatformConfiguration>(Customer.class, Role.class,
            Location.class, Company.class, Attribute.class, SkillRating.class, CXRating.class, Interview.class, Request.class, Qualifications.class,
            Skill.class, Channel.class, Degree.class, Institute.class, Slot.class, InterviewEvaluation.class, InterviewRating.class,
            RequestToSlot.class, Session.class) {
        public DataSourceFactory getDataSourceFactory(PlatformConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    private final GuiceBundle<PlatformConfiguration> guiceBundle = GuiceBundle.<PlatformConfiguration>newBuilder()
            .setConfigClass(PlatformConfiguration.class)
            .enableAutoConfig(getClass().getPackage().getName())
            .setInjectorFactory((stage, modules) -> LifecycleInjector.builder()
                    .inStage(stage)
                    .withModules(modules)
                    .build()
                    .createInjector())
            .addModule(new PlatformModule(hibernateBundle))
            .build();

    @Override
    public void initialize(Bootstrap<PlatformConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        bootstrap.addBundle(guiceBundle);
    }

    public static void main(String[] args) throws Exception {
        new PlatformApplication().run(args);
    }

    @Override
    public String getName() {
        return "platform";
    }

    @Override
    public void run(PlatformConfiguration platformConfiguration, Environment environment) throws Exception {
        /*final CustomerResource customerResource = new CustomerResource(platformConfiguration.getTemplate());
        environment.jersey().register(customerResource);
*/
        SessionDAO sessionDAO = guiceBundle.getInjector().getInstance(SessionDAO.class);
        environment.jersey().register(AuthFactory.binder(
                new OAuthFactory<>(
                        new SessionAuthenticator(sessionDAO),
                        "SECURITY REALM",
                        Session.class)));

        final AppInRotationHealthCheck healthCheck = new AppInRotationHealthCheck(platformConfiguration.getTemplate());
        environment.healthChecks().register("app-health", healthCheck);
    }
}
