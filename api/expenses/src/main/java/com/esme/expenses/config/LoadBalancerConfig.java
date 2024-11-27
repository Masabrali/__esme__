package com.esme.expenses.config;

import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadBalancerConfig {

    @Bean
    public ServiceInstanceListSupplier discoveryClientListInstanceSupplier(ConfigurableApplicationContext context) {

        return ServiceInstanceListSupplier.builder().withBlockingDiscoveryClient().withSameInstancePreference().build(context);

    }

}
