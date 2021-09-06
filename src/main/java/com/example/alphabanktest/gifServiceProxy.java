package com.example.alphabanktest;

import org.springframework.cloud.openfeign.FeignClient;


// 274aO2atwB51v7uRz7CwoHT3cqAnTvBr
@FeignClient(name = "api-service2", url = "api.giphy.com/v1/gifs")
public interface gifServiceProxy extends GifInterface {

}
