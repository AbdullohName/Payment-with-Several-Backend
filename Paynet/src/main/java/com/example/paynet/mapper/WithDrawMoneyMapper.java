package com.example.paynet.mapper;

import com.example.paynet.model.dto.PhoneNumberPaymentDto;
import com.example.paynet.model.dto.WithdrawMoneyDto;
import org.springframework.context.annotation.Bean;

public class WithDrawMoneyMapper {

    public static WithdrawMoneyDto moneyDto(PhoneNumberPaymentDto phoneNumberPaymentDto) {
        WithdrawMoneyDto withdrawMoneyDto = new WithdrawMoneyDto();
        withdrawMoneyDto.setTransAcId(phoneNumberPaymentDto.getTransAcId());
        withdrawMoneyDto.setPrice(phoneNumberPaymentDto.getPrice());
        withdrawMoneyDto.setCardNumberTakeOff(phoneNumberPaymentDto.getCardNumber());
        return withdrawMoneyDto;
    }
}
