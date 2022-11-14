package infinity.ucellservice.service;

import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface UcellService {
    ResponseDto<String> payment(PaymentDto paymentDto);
    ResponseDto<String> rollBackPayment(Long id);
}
