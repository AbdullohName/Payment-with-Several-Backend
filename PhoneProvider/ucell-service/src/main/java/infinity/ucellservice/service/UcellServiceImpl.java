package infinity.ucellservice.service;

import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;
import infinity.ucellservice.model.entity.Ucell;
import infinity.ucellservice.model.entity.UcellHistory;
import infinity.ucellservice.repository.UcellHistoryRepository;
import infinity.ucellservice.repository.UcellRepository;
import infinity.ucellservice.service.mapper.PaymentHistoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Optional;

@RequiredArgsConstructor @Service
public class UcellServiceImpl implements UcellService{
    private final UcellRepository informationRepository;
    private final UcellHistoryRepository paymentHistoryRepository;
    @Override
    public ResponseDto<String> payment(PaymentDto paymentDto) {
        Optional<Ucell> optional = informationRepository.findByPhoneNumber(paymentDto.getPhoneNumber());
        if(optional.isPresent()) {
            Ucell information = optional.get();
            UcellHistory paymentHistory = PaymentHistoryMapper.toEntity(information, paymentDto.getTransAcId());
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
                .success(false).data("This number is not found").build();
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
