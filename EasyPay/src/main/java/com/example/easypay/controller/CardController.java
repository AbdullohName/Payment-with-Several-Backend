package com.example.easypay.controller;

import com.example.easypay.dto.CardBalanceDto;
import com.example.easypay.dto.CardDto;
import com.example.easypay.dto.CardDtoExchange;
import com.example.easypay.dto.ResponseDto;
import com.example.easypay.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@RestController @RequestMapping("/card") @RequiredArgsConstructor @CrossOrigin
public class CardController {

    private final CardService service;
    @PostMapping
    public ResponseDto<String> addCard(@RequestBody CardDto cardDto) {
        return service.addCard(cardDto);
    }
    @GetMapping
    public ResponseDto<List<List<CardBalanceDto>>> getAllCardBalance() {
        return service.getAllCardBalanceByUser();
    }
    @DeleteMapping
    public ResponseDto<String> deleteCardByNumber(@RequestParam @Size(min = 19,max = 19) String cardNumber) {
        return service.deleteCardByNumber(cardNumber);
    }
}
