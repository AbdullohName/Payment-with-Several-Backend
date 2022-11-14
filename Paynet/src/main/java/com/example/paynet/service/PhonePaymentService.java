package com.example.paynet.service;

import com.example.paynet.model.dto.PhoneNumberPaymentDto;
import com.example.paynet.model.dto.ResponseDto;

public interface PhonePaymentService {
    ResponseDto<Long> beeline(PhoneNumberPaymentDto phoneNumberPaymentDto);
    ResponseDto<Long> ucell(PhoneNumberPaymentDto phoneNumberPaymentDto);
    ResponseDto<Long> uzMobile(PhoneNumberPaymentDto phoneNumberPaymentDto);
    ResponseDto<Long> perfectum(PhoneNumberPaymentDto phoneNumberPaymentDto);
    ResponseDto<Long> mobiUz(PhoneNumberPaymentDto phoneNumberPaymentDto);

}
