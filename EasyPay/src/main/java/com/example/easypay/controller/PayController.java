package com.example.easypay.controller;

import com.example.easypay.dto.ResponseDto;
import com.example.easypay.dto.SendServerForPay;
import com.example.easypay.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController @RequestMapping("/pay") @CrossOrigin
public class PayController {
    @Autowired
    private PayService payService;
    @PostMapping
    public ResponseDto<String> payment(@RequestBody @Valid SendServerForPay serverForPay) {
        return payService.paymentMobile(serverForPay);
    }

    @PostMapping("/rollback")
    public ResponseDto<Void> rollBackPayment(@RequestBody @NotNull Long transAcId) {
        return payService.rollBackPayment(transAcId);
    }
}
