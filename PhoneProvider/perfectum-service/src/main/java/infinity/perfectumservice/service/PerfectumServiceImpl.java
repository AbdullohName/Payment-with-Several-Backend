package infinity.perfectumservice.service;

import infinity.perfectumservice.model.entity.Perfectum;
import infinity.perfectumservice.model.entity.PerfectumHistory;
import infinity.perfectumservice.repository.PerfectumHistoryRepository;
import infinity.perfectumservice.repository.PerfectumRepository;
import infinity.perfectumservice.service.mapper.PaymentHistoryMapper;
import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PerfectumServiceImpl implements PerfectumService{
    private final PerfectumRepository informationRepository;
    private final PerfectumHistoryRepository paymentHistoryRepository;
    @Override
    public ResponseDto<String> payment(PaymentDto paymentDto) {
        Optional<Perfectum> optional = informationRepository.findByPhoneNumber(paymentDto.getPhoneNumber());
        if(optional.isPresent()) {
            Perfectum information = optional.get();
            PerfectumHistory perfectumMobileHistory = PaymentHistoryMapper.toEntity(information, paymentDto.getTransAcId());
            information.setAccount(information.getAccount() + paymentDto.getPrice());
            paymentHistoryRepository.save(perfectumMobileHistory);
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
