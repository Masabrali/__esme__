package com.esme.expenses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eureka.client.eurekaclientthree.clients.ProducerFeignClient;
import com.eureka.client.eurekaclientthree.dtos.Product;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;



@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class IndexController {

    private final ProducerFeignClient producerFeignClient;

    @Value("${microservice-two.value}")
    private Integer value;

    @Value("${message}")
    private String message;

    public String fallback() {
        return "Circuit breaker fallback";
    }

    @GetMapping("products")
    @Retry(name = "eurekaclientproducer", fallbackMethod = "fallback")
    @CircuitBreaker(name = "eurekaclientproducer", fallbackMethod = "fallback")
    public List<Product> getProducts() {
        return producerFeignClient.getData();
    }

    @GetMapping("products/{id}")
    @Retry(name = "eurekaclientproducer", fallbackMethod = "fallback")
    @CircuitBreaker(name = "eurekaclientproducer", fallbackMethod = "fallback")
    public Product getProducts(@PathVariable("id") Integer id) {
        return producerFeignClient.getProduct(id);
    }

    @GetMapping("/value")
    public Integer getValue() {
        return value;
    }

    @GetMapping("/message")
    public String getMessage() {
        return message;
    }

}
