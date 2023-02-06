package com.in28minutes.microservices.currencyexchangeservices.controller;

import com.in28minutes.microservices.currencyexchangeservices.entity.CurrencyExchange;
import com.in28minutes.microservices.currencyexchangeservices.entity.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    Environment environment ;

    @Autowired
    CurrencyExchangeRepository repo ;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to){
        CurrencyExchange currencyExchange = repo.findByFromAndTo(from,to);
        if(currencyExchange==null){
            throw new RuntimeException("Unable to find data for " + from +" to" + to);
        }
        String port = environment.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);
        return currencyExchange;
    }
}
