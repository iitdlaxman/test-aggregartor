package com.flipkart.crm.services.healthCheck;

import com.codahale.metrics.health.HealthCheck;

/**
 * Created by laxman.muttineni on 18/07/17.
 */
public class AppInRotationHealthCheck extends HealthCheck {
    private final String template;

    public AppInRotationHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String greeting = String.format(template, "TEST");
        if (!greeting.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }
}