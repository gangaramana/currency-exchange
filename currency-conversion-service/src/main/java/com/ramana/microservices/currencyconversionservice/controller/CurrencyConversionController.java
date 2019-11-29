package com.ramana.microservices.currencyconversionservice.controller;

import com.ramana.microservices.currencyconversionservice.feignController.CurrencyExchangeServiceProxy;
import com.ramana.microservices.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeServiceProxy proxy;

//    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
//    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
//        Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("from", from);
//        uriVariables.put("to", to);
//        ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000//currency-exchabe/{from}/from/{to}", CurrencyConversionBean.class, uriVariables);
//        CurrencyConversionBean response = responseEntity.getBody();
//
//        return new CurrencyConversionBean(response.getId(), from, to, quantity, response.getConversionMultiple(), quantity.multiply(response.getConversionMultiple()),response.getPort());
//    }

    @GetMapping("/currency-converter_feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean convertCurrencyFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversionBean response = proxy.exchangeValue(from, to);

        return new CurrencyConversionBean(response.getId(), from, to, quantity, response.getConversionMultiple(), quantity.multiply(response.getConversionMultiple()),response.getPort());
    }
}
