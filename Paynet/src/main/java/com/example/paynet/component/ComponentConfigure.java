package com.example.paynet.component;

import com.example.paynet.model.entity.CardTransfer;
import com.example.paynet.repository.CardTransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component @RequiredArgsConstructor
public class ComponentConfigure {
    public CardTransfer cardTransfer;
    private final CardTransferRepository cardTransferRepository;
    @PostConstruct
    public void getCard() {
//        Optional<CardTransfer> optionalCardTransfer = cardTransferRepository.findById(1l);
//        if(optionalCardTransfer.isPresent()) {
//            cardTransfer = optionalCardTransfer.get();
//        }
    }
}
