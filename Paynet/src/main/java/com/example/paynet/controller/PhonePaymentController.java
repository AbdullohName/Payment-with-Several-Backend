package com.example.paynet.controller;

import com.example.paynet.model.dto.PhoneNumberPaymentDto;
import com.example.paynet.model.dto.ResponseDto;
import com.example.paynet.service.PhonePaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController @RequestMapping("/phone") @RequiredArgsConstructor
public class PhonePaymentController  {
    private final PhonePaymentService service;
    @PostMapping("/beeline")
    public ResponseDto<Long> beeline(@RequestBody PhoneNumberPaymentDto phoneNumberPaymentDto) {
        return service.beeline(phoneNumberPaymentDto);
    }
    @PostMapping("/ucell")
    public ResponseDto<Long> ucell(@RequestBody PhoneNumberPaymentDto phoneNumberPaymentDto) {
        return service.ucell(phoneNumberPaymentDto);
    }
    @PostMapping("/uzmobile")
    public ResponseDto<Long> uzMobile(@RequestBody PhoneNumberPaymentDto phoneNumberPaymentDto) {

        return service.uzMobile(phoneNumberPaymentDto);
    }
    @PostMapping("/perfectum")
    public ResponseDto<Long> perfectum(@RequestBody PhoneNumberPaymentDto phoneNumberPaymentDto) {

        return service.perfectum(phoneNumberPaymentDto);
    }

    @PostMapping("/mobiuz")
    public ResponseDto<Long> mobiUz(@RequestBody PhoneNumberPaymentDto phoneNumberPaymentDto) {

        return service.mobiUz(phoneNumberPaymentDto);
    }
}
