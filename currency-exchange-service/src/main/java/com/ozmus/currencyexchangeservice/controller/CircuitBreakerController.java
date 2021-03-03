package com.ozmus.currencyexchangeservice.controller;

import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {
    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
    @Retry(name = "sample-api", fallbackMethod = "hardCodedResponse") //will retry for 5 times then return error
    public String sampleApi(){
        logger.info("Sample Api call is received.");
        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8000/some-dummy", String.class);
        return forEntity.getBody();
    }

    private String hardCodedResponse(Exception e){
        return "fallback-response";
    }
}
