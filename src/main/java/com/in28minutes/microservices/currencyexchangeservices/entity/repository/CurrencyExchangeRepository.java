package com.in28minutes.microservices.currencyexchangeservices.entity.repository;

import com.in28minutes.microservices.currencyexchangeservices.entity.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange,Long> {

    public CurrencyExchange findByFromAndTo(String from,String to);

}
