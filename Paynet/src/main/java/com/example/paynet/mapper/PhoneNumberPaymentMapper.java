package com.example.paynet.mapper;

import com.example.paynet.model.dto.PhoneNumberPaymentDto;
import com.example.paynet.model.entity.PhoneNumberPayment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PhoneNumberPaymentMapper {
    PhoneNumberPayment toEntity(PhoneNumberPaymentDto phoneNumberPaymentDto);
}
