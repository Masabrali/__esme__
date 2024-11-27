package com.esme.expenses.clients;

import java.util.List;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.eureka.client.eurekaclientthree.config.LoadBalancerConfig;
import com.eureka.client.eurekaclientthree.dtos.Product;


@FeignClient(name = "producer-feign-client", url = "http://localhost:8092/api/")
@LoadBalancerClient(name = "producer-feign-client", configuration = LoadBalancerConfig.class)
public interface ProducerFeignClient {

    @GetMapping("products")
    List<Product> getData();

    @GetMapping("products/{id}")
    Product getProduct(@PathVariable("id") Integer id);

    @GetMapping("products")
    Product getProductByName(@RequestParam String name);
    
}
