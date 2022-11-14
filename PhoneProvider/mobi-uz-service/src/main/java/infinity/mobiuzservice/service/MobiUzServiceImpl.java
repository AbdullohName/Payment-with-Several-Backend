package infinity.mobiuzservice.service;


import infinity.mobiuzservice.model.entity.MobiUz;
import infinity.mobiuzservice.model.entity.MobiUzHistory;
import infinity.mobiuzservice.repository.MobiUzHistoryRepository;
import infinity.mobiuzservice.repository.MobiUzRepository;
import infinity.mobiuzservice.service.mapper.PaymentHistoryMapper;
import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service @RequiredArgsConstructor
public class MobiUzServiceImpl implements MobiUzService {
    private final MobiUzRepository informationRepository;
    private final MobiUzHistoryRepository paymentHistoryRepository;
    @Override
    @Transactional
    public ResponseDto<String> payment(PaymentDto paymentDto) {
        Optional<MobiUz> optional = informationRepository.findByPhoneNumber(paymentDto.getPhoneNumber());
        if(optional.isPresent()) {
            MobiUz information = optional.get();
            MobiUzHistory paymentHistory = PaymentHistoryMapper.toEntity(information, paymentDto.getTransAcId());
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
