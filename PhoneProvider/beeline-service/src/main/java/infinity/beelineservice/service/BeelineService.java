package infinity.beelineservice.service;

import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;

public interface BeelineService {
    ResponseDto<String> payment(PaymentDto paymentDto);
    ResponseDto<String> rollBackPayment(Long id);
}
