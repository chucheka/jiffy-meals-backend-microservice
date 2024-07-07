package com.chucheka.payment_service.config;

import io.micrometer.observation.ObservationRegistry;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    private final ObservationRegistry registry;

    public AppConfig(ObservationRegistry registry) {
        this.registry = registry;
    }
}