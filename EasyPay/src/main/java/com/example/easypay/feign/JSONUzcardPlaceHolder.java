package com.example.easypay.feign;

import com.example.easypay.configuration.MyClientConfiguration;
import com.example.easypay.dto.CardDto;
import com.example.easypay.dto.CardDtoExchange;
import com.example.easypay.dto.RequestDtoForBalance;
import com.example.easypay.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "uzcard",url = "http://localhost:9100/api",configuration = MyClientConfiguration.class)
public interface JSONUzcardPlaceHolder {
    @RequestMapping(method = RequestMethod.POST,value = "/uzcard",produces = "application/json")
    ResponseDto<List<CardDtoExchange>> getUzCards(@RequestBody RequestDtoForBalance uzcard);

    @RequestMapping(method = RequestMethod.POST,value = "/checkCard",produces = "application/json")
    ResponseDto checkCard(@RequestParam("phoneNumber") String phoneNumber);

    @RequestMapping(method = RequestMethod.GET,value = "/uzcard",produces = "application/json")
    ResponseDto<CardDtoExchange> getByCardNumber(@RequestParam("cardNumber") String cardNumber);
}
