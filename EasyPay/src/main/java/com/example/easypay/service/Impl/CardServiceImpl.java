package com.example.easypay.service.Impl;

import com.example.easypay.dto.*;
import com.example.easypay.entity.Card;
import com.example.easypay.entity.Users;
import com.example.easypay.feign.JSONHumoPlaceHolder;
import com.example.easypay.feign.JSONUzcardPlaceHolder;
import com.example.easypay.repository.CardRepository;
import com.example.easypay.repository.UsersRepository;
import com.example.easypay.service.CardService;
import com.example.easypay.service.mapper.CardBalanceMapper;
import com.example.easypay.service.mapper.CardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service @RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardRepository repository;
    private final CardMapper mapper;
    private final UsersRepository usersRepository;
    private final JSONHumoPlaceHolder humoPlaceHolder;
    private final JSONUzcardPlaceHolder uzcardPlaceHolder;
    @Override
    public ResponseDto<String> addCard(CardDto cardDto) {
        Card card = mapper.toEntity(cardDto);

        if(repository.existsById(card.getId())) {
            return ResponseDto.<String>builder().code(-1).message("failed").success(false).data("This Card already exist").build();
        }
        if(cardDto.getNumber().startsWith("8600")) {
            ResponseDto responseDto = uzcardPlaceHolder.checkCard(card.getNumber());
            if(!responseDto.getSuccess()) {
                return ResponseDto.<String>builder().code(-2).message("Failed").success(false).data("Card not found").build();
            }
        } else {
            ResponseDto responseDto = humoPlaceHolder.checkCard(card.getNumber());
            if(!responseDto.getSuccess()) {
                return ResponseDto.<String>builder().code(-2).message("Failed").success(false).data("Card not found").build();
            }
        }
        repository.save(card);
        return ResponseDto.<String>builder().code(0).message("ok").success(true).data("Success").build();
    }

    @Override
    public ResponseDto<List<List<CardBalanceDto>>> getAllCardBalanceByUser() {

        UserInfoDto userInfoDto = (UserInfoDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Optional<Users> users = usersRepository.findById(userInfoDto.getId());

        if(users.isPresent()) {
            List<String> cardDtoList = users.get().getCardList().stream().map(s->s.getNumber()).collect(Collectors.toList());
            List<String> uzcardList = new ArrayList<>();
            List<String> humoList = new ArrayList<>();
            for(String card: cardDtoList) {
                if(card.startsWith("8600")) uzcardList.add(card);
                else humoList.add(card);
            }

            List<List<CardBalanceDto>> cardList = new ArrayList<>();
            if(uzcardList.size() != 0) {
                RequestDtoForBalance requestUzcard = new RequestDtoForBalance(users.get().getPhoneNumber(),uzcardList);
                List<CardDtoExchange> uzcards =  uzcardPlaceHolder.getUzCards(requestUzcard).getData();
                
                cardList.add(CardBalanceMapper.toDto(uzcards));
            }
            if(humoList.size() != 0) {
                RequestDtoForBalance requestHumo = new RequestDtoForBalance(users.get().getPhoneNumber(),humoList);
                List<CardDtoExchange> cardDtoExchangeList = humoPlaceHolder.getHumoCards(requestHumo).getData();

                cardList.add(CardBalanceMapper.toDto(cardDtoExchangeList));
            }

            return ResponseDto.<List<List<CardBalanceDto>>>builder().code(0).message("ok").success(true).data(cardList).build();
        }
        return ResponseDto.<List<List<CardBalanceDto>>>builder().code(-4).message("Not found").success(false).build();
    }

    @Override @Transactional
    public ResponseDto<String> deleteCardByNumber(String cardNumber) {
        try {
            repository.deleteByNumber(cardNumber);
            return ResponseDto.<String>builder()
                    .code(0)
                    .message("Ok")
                    .success(true)
                    .data("SuccessFully delete")
                    .build();
        } catch (Exception e) {
            return ResponseDto.<String>builder()
                    .code(-1)
                    .message("Failed")
                    .success(false)
                    .build();
        }
    }

    @Override
    public ResponseDto<CardBalanceDto> getByCardNumber(String cardNumber) {
        UserInfoDto userInfoDto = (UserInfoDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<Card> optionalCard = repository.findByNumber(cardNumber);
        if(optionalCard.isPresent() && optionalCard.get().getUserId().equals(userInfoDto.getId())) {
            Card card =  optionalCard.get();
            if(card.getNumber().startsWith("8600")) {

            } else {

            }
        }
        return null;
    }
}
