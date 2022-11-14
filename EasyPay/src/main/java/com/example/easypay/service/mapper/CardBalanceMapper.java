package com.example.easypay.service.mapper;

import com.example.easypay.dto.CardBalanceDto;
import com.example.easypay.dto.CardDtoExchange;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
//@Component
public class CardBalanceMapper {
    public static List<CardBalanceDto> toDto(List<CardDtoExchange> exchange) {
        List<CardBalanceDto> cardBalanceDtos = new ArrayList<>();
        for(CardDtoExchange card: exchange) {
            CardBalanceDto cardBalanceDto = new CardBalanceDto();
            cardBalanceDto.setCardNumber(card.getCardNumber());
            cardBalanceDto.setBalance(card.getBalance());
            cardBalanceDto.setBankName(card.getBankName());
            cardBalanceDto.setFullName(card.getFullName());
            cardBalanceDto.setPhoneNumber(card.getPhoneNumber());
            cardBalanceDto.setValidThru(card.getValidThru());
            cardBalanceDtos.add(cardBalanceDto);
        }
        return cardBalanceDtos;
    }
}
