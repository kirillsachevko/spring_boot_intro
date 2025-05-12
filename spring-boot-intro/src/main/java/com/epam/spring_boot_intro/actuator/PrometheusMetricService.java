package com.epam.spring_boot_intro.actuator;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

@Component
public class PrometheusMetricService {
    private final Counter requestCounter;

    public PrometheusMetricService(MeterRegistry meterRegistry) {
        this.requestCounter = meterRegistry.counter("custom.requests", "endpoint", "/custom-endpoint");
    }

    public void incrementCustomRequestCounter() {
        requestCounter.increment();
    }
}
