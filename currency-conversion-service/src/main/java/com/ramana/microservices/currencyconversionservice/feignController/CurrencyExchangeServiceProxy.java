package com.ramana.microservices.currencyconversionservice.feignController;

import com.ramana.microservices.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "currency-exchange-service", url = "currency-exchange-service-2.default.svc.cluster.local:8000")
//@FeignClient(name ="currency-exchange-service")
//@RibbonClient(name="currency-exchange-service")
public interface CurrencyExchangeServiceProxy {
    @GetMapping("/currency-exchabe/{from}/from/{to}")
    public CurrencyConversionBean exchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
