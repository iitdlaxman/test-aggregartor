package com.flipkart.crm.services;

import com.flipkart.crm.entity.user.Customer;
import com.flipkart.crm.services.configuration.PlatformConfiguration;
import com.flipkart.crm.services.guice.PlatformModule;
import com.flipkart.crm.services.healthCheck.AppInRotationHealthCheck;
import com.flipkart.crm.services.resources.CustomerResource;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Stage;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.hubspot.dropwizard.guice.InjectorFactory;
import com.netflix.governator.guice.LifecycleInjector;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

import java.util.List;

/**
 * Created by laxman.muttineni on 18/07/17.
 */
public class PlatformApplication extends Application<PlatformConfiguration> {

    private final GuiceBundle<PlatformConfiguration> guiceBundle = GuiceBundle.<PlatformConfiguration>newBuilder()
            .setConfigClass(PlatformConfiguration.class)
            .enableAutoConfig(getClass().getPackage().getName())
            .setInjectorFactory((stage, modules) -> LifecycleInjector.builder()
                    .inStage(stage)
                    .withModules(modules)
                    .build()
                    .createInjector())
            .addModule(new PlatformModule())
            .build();

    private final HibernateBundle<PlatformConfiguration> hibernateBundle = new HibernateBundle<PlatformConfiguration>(Customer.class) {
        public DataSourceFactory getDataSourceFactory(PlatformConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

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
        final AppInRotationHealthCheck healthCheck = new AppInRotationHealthCheck(platformConfiguration.getTemplate());
        environment.healthChecks().register("app-health", healthCheck);
    }
}
