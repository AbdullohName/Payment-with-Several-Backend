package com.example.easypay.feign;

import com.example.easypay.configuration.MyClientConfiguration;
import com.example.easypay.dto.ResponseDto;
import com.example.easypay.dto.SendServerForPay;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@FeignClient(value = "Paynet",url = "http://localhost:8088/api/phone",configuration = MyClientConfiguration.class)
public interface JSONPaynetPlaceHolder {
    @RequestMapping(method = RequestMethod.POST,value = "/beeline")
    ResponseDto<Long> paymentBeeline(@RequestBody SendServerForPay serverForPay);

    @RequestMapping(method = RequestMethod.POST,value = "/ucell")
    ResponseDto<Long> paymentUcell(@RequestBody SendServerForPay serverForPay);

    @RequestMapping(method = RequestMethod.POST,value = "/uzmobile")
    ResponseDto<Long> paymentUzMobile(@RequestBody SendServerForPay serverForPay);

    @RequestMapping(method = RequestMethod.POST,value = "/mobiuz")
    ResponseDto<Long> paymentMobiUz(@RequestBody SendServerForPay serverForPay);

    @RequestMapping(method = RequestMethod.POST,value = "/perfectum")
    ResponseDto<Long> paymentPerfectum(@RequestBody SendServerForPay serverForPay);
}

