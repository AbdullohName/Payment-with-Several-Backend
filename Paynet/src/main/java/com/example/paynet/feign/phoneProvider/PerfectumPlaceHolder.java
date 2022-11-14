package com.example.paynet.feign.phoneProvider;

import com.example.paynet.configuration.MyClientConfiguration;
import com.example.paynet.model.dto.PhoneNumberPaymentDto;
import com.example.paynet.model.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "perfectum",url = "http://localhost:9002/api",configuration = MyClientConfiguration.class)
public interface PerfectumPlaceHolder {
    @RequestMapping(method = RequestMethod.POST,value = "/perfectum",produces = "application/json")
    ResponseDto<String> Perfectum(@RequestBody PhoneNumberPaymentDto phoneNumberPaymentDto);

    @RequestMapping(method = RequestMethod.POST,value = "/rollBack",produces = "application/json")
    ResponseDto<Void> rollBack(@RequestBody Long transAcId);
}
