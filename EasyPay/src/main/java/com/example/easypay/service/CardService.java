package com.example.easypay.service;

import com.example.easypay.dto.CardBalanceDto;
import com.example.easypay.dto.CardDto;
import com.example.easypay.dto.CardDtoExchange;
import com.example.easypay.dto.ResponseDto;

import java.util.List;

public interface CardService {
    ResponseDto<String> addCard(CardDto cardDto);
    ResponseDto<List<List<CardBalanceDto>>> getAllCardBalanceByUser();
    ResponseDto<String> deleteCardByNumber(String cardNumber);
    ResponseDto<CardBalanceDto> getByCardNumber(String cardNumber);
}
