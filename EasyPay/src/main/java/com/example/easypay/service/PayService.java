package com.example.easypay.service;

import com.example.easypay.dto.ResponseDto;
import com.example.easypay.dto.SendServerForPay;

public interface PayService {
    ResponseDto<String> paymentMobile(SendServerForPay serverForPay);
    ResponseDto<Void> rollBackPayment(Long transAcId);

}
