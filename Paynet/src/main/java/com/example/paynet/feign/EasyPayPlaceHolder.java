package com.example.paynet.feign;

import com.example.paynet.configuration.MyClientConfiguration;
import com.example.paynet.model.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "EasyPay",url = "http://localhost:8080/api/pay",configuration = MyClientConfiguration.class)
public interface EasyPayPlaceHolder {
    @RequestMapping(method = RequestMethod.POST,value = "/rollback",produces = "application/json")
    ResponseDto<Void> rollBack(@RequestBody Long transAcId);
}
