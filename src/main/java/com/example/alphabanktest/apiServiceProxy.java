package com.example.alphabanktest;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "api-service", url = "https://openexchangerates.org/api/historical")
public interface apiServiceProxy extends CurrencyInterface {


}
