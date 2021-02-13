package com.ozmus.limitsservice.controller;

import com.ozmus.limitsservice.bean.Limits;
import com.ozmus.limitsservice.configuration.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsController {

    private final Configuration configuration;

    public LimitsController(Configuration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/limits")
    public Limits getLimits(){
        return new Limits(configuration.getMinimum(), configuration.getMaximum());
    }
}
