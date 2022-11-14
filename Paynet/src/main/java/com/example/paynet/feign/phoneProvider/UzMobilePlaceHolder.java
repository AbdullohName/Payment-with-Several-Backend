package com.example.paynet.feign.phoneProvider;

import com.example.paynet.configuration.MyClientConfiguration;
import com.example.paynet.model.dto.PhoneNumberPaymentDto;
import com.example.paynet.model.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "uzMobile",url = "http://localhost:9004/api",configuration = MyClientConfiguration.class)
public interface UzMobilePlaceHolder {
    @RequestMapping(method = RequestMethod.POST,value = "/uzmobile",produces = "application/json")
    ResponseDto<String> UzMobile(@RequestBody PhoneNumberPaymentDto phoneNumberPaymentDto);

    @RequestMapping(method = RequestMethod.POST,value = "/rollBack",produces = "application/json")
    ResponseDto<Void> rollBack(@RequestBody Long transAcId);
}
