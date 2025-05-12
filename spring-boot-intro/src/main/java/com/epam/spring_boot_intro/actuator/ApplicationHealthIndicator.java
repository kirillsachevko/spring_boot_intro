package com.epam.spring_boot_intro.actuator;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class ApplicationHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        boolean isHealthy = checkResourceHealth();
        if (isHealthy) {
            return Health.up().withDetail("CustomResource", "Healthy").build();
        } else {
            return Health.down()
                    .withDetail("CustomResource", "Unhealthy")
                    .withDetail("Error", "Resource unreachable").build();
        }
    }

    private boolean checkResourceHealth() {
        return true;
    }
}
