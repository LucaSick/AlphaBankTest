package com.example.alphabanktest;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Hashtable;
import java.util.List;

public interface CurrencyInterface {
    @GetMapping("/{date}.json")
    public Object getCountries(@PathVariable("date") String date,
                                    @RequestParam("app_id") String app_id);

    //@GetMapping("/products")
    //public List<Object> getProducts();
}
