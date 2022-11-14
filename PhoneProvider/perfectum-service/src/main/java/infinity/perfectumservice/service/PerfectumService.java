package infinity.perfectumservice.service;

import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;

public interface PerfectumService {
    ResponseDto<String> payment(PaymentDto paymentDto);
    ResponseDto<String> rollBackPayment(Long id);
}
