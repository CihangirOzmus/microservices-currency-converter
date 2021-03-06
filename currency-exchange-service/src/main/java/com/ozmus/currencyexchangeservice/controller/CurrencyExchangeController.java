package com.ozmus.currencyexchangeservice.controller;

import com.ozmus.currencyexchangeservice.domain.CurrencyExchange;
import com.ozmus.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    private final Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);

    private final Environment environment;

    private final CurrencyExchangeRepository repository;

    public CurrencyExchangeController(Environment environment, CurrencyExchangeRepository repository) {
        this.environment = environment;
        this.repository = repository;
    }

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange getExchangeValue(@PathVariable String from, @PathVariable String to){
        logger.info("getExchangeValue called with {} to {}", from, to);

        CurrencyExchange currencyExchange = repository.findCurrencyExchangeByFromAndTo(from, to);

        if (currencyExchange == null)
            throw new RuntimeException("Unable to find fata for " + from + " to " + to);

        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        return currencyExchange;
    }
}
