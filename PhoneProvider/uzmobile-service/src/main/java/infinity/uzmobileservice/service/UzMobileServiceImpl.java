package infinity.uzmobileservice.service;


import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;
import infinity.uzmobileservice.model.entity.Uzmobile;
import infinity.uzmobileservice.model.entity.UzmobileHistory;
import infinity.uzmobileservice.repository.UzmobileHistoryRepository;
import infinity.uzmobileservice.repository.UzmobileRepository;
import infinity.uzmobileservice.service.mapper.UzmobileHistoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service @RequiredArgsConstructor
public class UzMobileServiceImpl implements UzMobileService{
    private final UzmobileRepository informationRepository;
    private final UzmobileHistoryRepository paymentHistoryRepository;
    @Override
    public ResponseDto<String> payment(PaymentDto paymentDto) {
        Optional<Uzmobile> optional = informationRepository.findByPhoneNumber(paymentDto.getPhoneNumber());
        if(optional.isPresent()) {
            Uzmobile information = optional.get();
            UzmobileHistory paymentHistory = UzmobileHistoryMapper.toEntity(information, paymentDto.getTransAcId());
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
                .data("This number is not found").build();
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
