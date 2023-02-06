package com.in28minutes.microservices.currencyexchangeservices.controller;

import com.in28minutes.microservices.currencyexchangeservices.entity.CurrecnyExchange;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
               // "/currency-exchange/from/USD/to/INR"
    public CurrecnyExchange retrieveExchangeValue(@PathVariable String from,
                                                  @PathVariable String to){
        return new CurrecnyExchange(1001L, from, to, BigDecimal.valueOf(82));

    }
}
