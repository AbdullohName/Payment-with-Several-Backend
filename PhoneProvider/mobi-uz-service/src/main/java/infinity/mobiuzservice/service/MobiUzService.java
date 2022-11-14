package infinity.mobiuzservice.service;

import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface MobiUzService {
    ResponseDto payment(PaymentDto paymentDto);
    ResponseDto rollBackPayment(Long id);
}
