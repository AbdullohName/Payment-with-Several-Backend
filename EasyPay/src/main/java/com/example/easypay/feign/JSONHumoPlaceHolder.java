package com.example.easypay.feign;

import com.example.easypay.configuration.MyClientConfiguration;
import com.example.easypay.dto.CardDtoExchange;
import com.example.easypay.dto.RequestDtoForBalance;
import com.example.easypay.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "humo",url = "http://localhost:9200/api",configuration = MyClientConfiguration.class)
public interface JSONHumoPlaceHolder {
    @RequestMapping(method = RequestMethod.POST,value = "/humo",produces = "application/json")
    ResponseDto<List<CardDtoExchange>> getHumoCards(@RequestBody RequestDtoForBalance humo);

    @RequestMapping(method = RequestMethod.POST,value = "/checkCard",produces = "application/json")
    ResponseDto checkCard(@RequestBody String cardNumber);
}
