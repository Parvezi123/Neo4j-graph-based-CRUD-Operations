package com.neo4j.graph.configuration;

import io.micrometer.core.aop.TimedAspect;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public TimedAspect timer(MeterRegistry registry) {
        return new TimedAspect(registry);
    }
}