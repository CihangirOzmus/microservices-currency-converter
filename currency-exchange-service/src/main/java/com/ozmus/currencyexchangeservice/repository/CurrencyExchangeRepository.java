package com.ozmus.currencyexchangeservice.repository;

import com.ozmus.currencyexchangeservice.domain.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    CurrencyExchange findCurrencyExchangeByFromAndTo(String from, String to);
}
