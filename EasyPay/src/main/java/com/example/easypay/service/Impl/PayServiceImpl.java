package com.example.easypay.service.Impl;

import com.example.easypay.dto.ResponseDto;
import com.example.easypay.dto.SendServerForPay;
import com.example.easypay.entity.Card;
import com.example.easypay.entity.HistoryPay;
import com.example.easypay.entity.UserSession;
import com.example.easypay.entity.Users;
import com.example.easypay.feign.JSONPaynetPlaceHolder;
import com.example.easypay.repository.HistoryRepository;
import com.example.easypay.repository.UserSessionRepository;
import com.example.easypay.repository.UsersRepository;
import com.example.easypay.service.PayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class PayServiceImpl implements PayService {
    private final UserSessionRepository userSessionRepository;
    private final UsersRepository usersRepository;
    private final JSONPaynetPlaceHolder paynetPlaceHolder;
    private final HistoryRepository historyRepository;

    @Override   // Payment to mobile
    public ResponseDto<String> paymentMobile(SendServerForPay serverForPay) {
        Optional<UserSession> userSession = userSessionRepository.findById(serverForPay.getUserId());
        ResponseDto<Long> responseDto = null;
        if(!userSession.isPresent() || userSession.get().getUserInfoDto().getCardList() == null) {
            return ResponseDto.<String>builder().code(-2).message("Not found").success(false).data("User or card not found").build();
        }
        List<Card> cardList = userSession.get().getUserInfoDto().getCardList();
        for(Card card: cardList) {
            if(card.getNumber().equals(serverForPay.getCardNumber())) {
                if ((serverForPay.getPhoneNumber().startsWith("+99890") || serverForPay.getPhoneNumber().startsWith("+99891")) && serverForPay.getProviderName().equals("beeline")) {
                    responseDto = paynetPlaceHolder.paymentBeeline(serverForPay);
                } else if ((serverForPay.getPhoneNumber().startsWith("+99893") || serverForPay.getPhoneNumber().startsWith("+99894")) && serverForPay.getProviderName().equals("ucell")) {
                    responseDto = paynetPlaceHolder.paymentUcell(serverForPay);
                } else if ((serverForPay.getPhoneNumber().startsWith("+99899") || serverForPay.getPhoneNumber().startsWith("+99895")) && serverForPay.getProviderName().equals("uzmobile")) {
                    responseDto = paynetPlaceHolder.paymentUzMobile(serverForPay);
                } else if ((serverForPay.getPhoneNumber().startsWith("+99897")) && serverForPay.getProviderName().equals("mobiuz")) {
                    responseDto = paynetPlaceHolder.paymentMobiUz(serverForPay);
                } else if (serverForPay.getPhoneNumber().startsWith("+99898") && serverForPay.getProviderName().equals("perfectum")){
                    responseDto = paynetPlaceHolder.paymentPerfectum(serverForPay);
                }
            }
            if(responseDto != null && responseDto.getSuccess()) {
                saveHistory(serverForPay,responseDto.getData());
                return ResponseDto.<String>builder().code(0).message("OK").success(true).data("Payment has been made").build();
            }
        }
        return ResponseDto.<String>builder().code(-2).message("Not found").success(false).data("Card Number not found").build();

    }

    @Override       // amalga oshmagan tolovni orqaga qaytarish
    public ResponseDto<Void> rollBackPayment(Long transAcId) {
        Optional<HistoryPay> optional =  historyRepository.findByPaymentNumberAndPaymentSuccess(transAcId,true);
        if(optional.isPresent()) {
            HistoryPay historyPay = optional.get();
            historyPay.setPaymentSuccess(false);
            historyRepository.save(historyPay);
            return ResponseDto.<Void>builder().code(0).success(true).message("Ok").build();
        }
        return ResponseDto.<Void>builder().code(-5).success(false).message("Failed").build();
    }

    // history
    public void saveHistory(SendServerForPay serverForPay, Long transAcId) {
        Optional<Users> userSession = usersRepository.findById(serverForPay.getUserId());
        HistoryPay historyPay = new HistoryPay();
        historyPay.setUserId(serverForPay.getUserId());
        historyPay.setFullName(userSession.get().getFirstName()  + " " + userSession.get().getLastName());
        historyPay.setCardNumber(serverForPay.getCardNumber());
        historyPay.setPay(serverForPay.getPrice());
        historyPay.setCashBack(0.);
        historyPay.setDate(new Date(System.currentTimeMillis()));
        historyPay.setPaymentNumber(transAcId);
        historyRepository.save(historyPay);
    }

}
