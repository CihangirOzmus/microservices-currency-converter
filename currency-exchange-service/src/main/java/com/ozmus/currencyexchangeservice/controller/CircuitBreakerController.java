package com.ozmus.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
    private final Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "sample-api", fallbackMethod = "hardCodedResponse") //will retry for 5 times then return error
//    @CircuitBreaker(name = "sample-api", fallbackMethod = "hardCodedResponse") //if a service is down, circuit breaker does not send request, directly returns the fallback response
//    @RateLimiter(name="default") //for 10s only allowed 10000 request calls
    @Bulkhead(name = "sample-api") //how many concurrent calls are allowed
    public String sampleApi(){
        logger.info("Sample Api call is received.");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8000/some-dummy", String.class);
//        return forEntity.getBody();
        return "sample-api";
    }

    private String hardCodedResponse(Exception e){
        return "fallback-response";
    }
}
