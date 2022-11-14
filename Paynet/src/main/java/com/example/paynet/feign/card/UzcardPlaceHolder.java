package com.example.paynet.feign.card;

import com.example.paynet.configuration.MyClientConfiguration;
import com.example.paynet.model.dto.ResponseDto;
import com.example.paynet.model.dto.WithdrawMoneyDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "uzcard",url = "http://localhost:9100/api",configuration = MyClientConfiguration.class)
public interface UzcardPlaceHolder {
    @RequestMapping(method = RequestMethod.POST,value = "/money",produces = "application/json")
    ResponseDto<String> withdrawMoney(@RequestBody WithdrawMoneyDto withdrawMoneyDto);

    @RequestMapping(method = RequestMethod.POST,value = "/rollBack",produces = "application/json")
    ResponseDto<Void> rollBack(@RequestBody Long transAcId);
}
