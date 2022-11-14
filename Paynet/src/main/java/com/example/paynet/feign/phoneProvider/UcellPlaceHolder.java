package com.example.paynet.feign.phoneProvider;

import com.example.paynet.configuration.MyClientConfiguration;
import com.example.paynet.model.dto.PhoneNumberPaymentDto;
import com.example.paynet.model.dto.ResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "ucell",url = "http://localhost:9003/api",configuration = MyClientConfiguration.class)
public interface UcellPlaceHolder {
    @RequestMapping(method = RequestMethod.POST,value = "ucell",produces = "application/json")
    ResponseDto<String> Ucell(@RequestBody PhoneNumberPaymentDto phoneNumberPaymentDto);

    @RequestMapping(method = RequestMethod.POST,value = "/rollBack",produces = "application/json")
    ResponseDto<Void> rollBack(@RequestBody Long transAcId);
}
