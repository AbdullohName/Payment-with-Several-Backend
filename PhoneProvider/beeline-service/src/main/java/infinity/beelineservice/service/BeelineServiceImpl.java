package infinity.beelineservice.service;


import infinity.beelineservice.model.entity.Beeline;
import infinity.beelineservice.model.entity.BeelineHistory;
import infinity.beelineservice.repository.BeelineHistoryRepository;
import infinity.beelineservice.repository.BeelineRepository;
import infinity.beelineservice.service.mapper.PaymentHistoryMapper;

import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service @RequiredArgsConstructor
public class BeelineServiceImpl implements BeelineService{
    private final BeelineRepository informationRepository;
    private final BeelineHistoryRepository paymentHistoryRepository;
    @Override
    public ResponseDto<String> payment(PaymentDto paymentDto) {
        Optional<Beeline> optional = informationRepository.findByPhoneNumber(paymentDto.getPhoneNumber());
        if(optional.isPresent()) {
            Beeline information = optional.get();
            BeelineHistory paymentHistory = PaymentHistoryMapper.toEntity(information, paymentDto.getTransAcId());
            information.setAccount(information.getAccount() + paymentDto.getPrice());
            paymentHistoryRepository.save(paymentHistory);
            return ResponseDto.<String>builder()
                    .code(0)
                    .message("Ok")
                    .success(true)
                    .data("Successfully payed: Your Balance: " + information.getAccount()).build();
        }
        return ResponseDto.<String>builder()
                .code(-2)
                .message("Failed")
                .success(false)
                .data("This phone number is not found")
                .build();
    }

    @Override
    public ResponseDto<String> rollBackPayment(Long id) {
        if(paymentHistoryRepository.existsById(id)) {
            paymentHistoryRepository.deleteById(id);
            return ResponseDto.<String>builder().code(0).message("Ok").success(true).build();
        }
        return ResponseDto.<String>builder().code(-1).message("Failed").success(false).build();
    }
}
