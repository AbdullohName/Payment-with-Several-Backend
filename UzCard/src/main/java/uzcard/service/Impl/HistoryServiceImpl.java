package uzcard.service.Impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uzcard.dto.WithdrawMoneyDto;
import uzcard.entity.History;
import uzcard.repository.HistoryRepository;

import java.sql.Date;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class HistoryServiceImpl {
    private final HistoryRepository repository;
    public void savePayHistory(WithdrawMoneyDto withdrawMoneyDto) {
//        Optional<History> optionalHistory = repository.findFirstByTransactionId(withdrawMoneyDto.getTransAcId());
        History history = new History();
//        if(!optionalHistory.isEmpty()) {
            history.setDate(new Date(System.currentTimeMillis()));
            history.setCardNumberTakeOff(withdrawMoneyDto.getCardNumberTakeOff());
            history.setCardNumberAddMoney(withdrawMoneyDto.getCardNumberAddMoney());
            history.setPrice(withdrawMoneyDto.getPrice());
            history.setTransactionId(withdrawMoneyDto.getTransAcId());
//        } else {
//            history = optionalHistory.get();
//        }
        repository.save(history);
    }
}
