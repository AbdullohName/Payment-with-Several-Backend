package uzcard.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uzcard.dto.ExchangeDto;
import uzcard.dto.ResponseDto;
import uzcard.dto.UzCardDto;
import uzcard.dto.WithdrawMoneyDto;
import uzcard.entity.History;
import uzcard.entity.UzCard;
import uzcard.repository.HistoryRepository;
import uzcard.service.mapper.UzCardMapper;
import uzcard.repository.UzCardRepository;
import uzcard.service.UzCardService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class UzCardServiceImpl implements UzCardService {
    private final UzCardRepository repository;
    private final UzCardMapper mapper;
    private final HistoryServiceImpl historyService;
    private final HistoryRepository historyRepository;
    @Override
    public ResponseDto<List<UzCardDto>> getAllByPhoneNumber(ExchangeDto exchange) {
        if(exchange.getCardNumber().size() != 0) {
            List<UzCardDto> uzCardDtoList = new ArrayList<>();
            for(String cardNumber: exchange.getCardNumber()) {
                uzCardDtoList.add(mapper.toDto(repository.findAllByPhoneNumberAndSms(cardNumber, exchange.getPhoneNumber())));
            }
            return ResponseDto.<List<UzCardDto>>builder().code(0).message("success").data(uzCardDtoList).success(true).build();
        }
//        if(exchange.getCardNumber().size() != 0) {
//            List<UzCard> uzCards = repository.findByCardNumber(exchange.getCardNumber());
//            List<UzCardDto> uzCardDtoList = mapper.toDtoList(uzCards);
//            return ResponseDto.<List<UzCardDto>>builder().code(0).message("success").data(uzCardDtoList).success(true).build();
//        }
        return ResponseDto.<List<UzCardDto>>builder().code(-1).message("Not found").data(null).success(false).build();
    }

    @Override
    public ResponseDto<Void> withdrawMoney(WithdrawMoneyDto drawMoney) {
        UzCard takeOff = repository.findByCardNumber(drawMoney.getCardNumberTakeOff());
        UzCard addMoney = repository.findByCardNumber(drawMoney.getCardNumberAddMoney());
        if(takeOff == null || addMoney == null) {
            return ResponseDto.<Void>builder().code(-1).message("Not found").success(false).build();
        }
        if(takeOff.getBalance() < drawMoney.getPrice()) {
            return ResponseDto.<Void>builder().code(-2).message("Price is low").success(false).build();
        }
        takeOff.setBalance(takeOff.getBalance() - drawMoney.getPrice());
        addMoney.setBalance(addMoney.getBalance() + drawMoney.getPrice());
        repository.save(takeOff);
        repository.save(addMoney);
        historyService.savePayHistory(drawMoney);
        System.out.println(drawMoney.getCardNumberTakeOff());
        System.out.println(drawMoney.getCardNumberAddMoney());
        return ResponseDto.<Void>builder().code(0).message("success").success(true).data(null).build();
    }

    @Override
    public ResponseDto<Void> rollbackPay(Long transAcId) {
        Optional<History> optionalHistory =  historyRepository.findFirstByTransactionId(transAcId);
        if(optionalHistory.isEmpty()) {
            return ResponseDto.<Void>builder().code(-1).message("Not found").success(false).build();
        }
        History history = optionalHistory.get();
        WithdrawMoneyDto withdrawMoneyDto = new WithdrawMoneyDto(history.getCardNumberAddMoney(), history.getPrice(), history.getCardNumberTakeOff(), history.getTransactionId());
        return withdrawMoney(withdrawMoneyDto);
    }

    @Override
    public ResponseDto<Void> checkCard(String cardNumber) {
        UzCard uzCard =  repository.findAllByCardNumberAndSms(cardNumber);
        if(uzCard != null) return ResponseDto.<Void>builder().code(0).success(true).message("Ok").build();
        return ResponseDto.<Void>builder().code(-3).success(false).message("Failed").build();
    }

    @Override
    public ResponseDto<UzCardDto> getByCardNumber(String cardNumber) {
        UzCard uzCard = repository.findByCardNumber(cardNumber);
        if(uzCard != null) {
            UzCardDto uzCardDto =  mapper.toDto(uzCard);
            return ResponseDto.<UzCardDto>builder()
                    .code(0)
                    .message("Ok")
                    .success(true)
                    .data(uzCardDto)
                    .build();
        }
        return ResponseDto.<UzCardDto>builder()
                .code(-1)
                .message("Don't Found Card")
                .success(false)
                .build();
    }

}
