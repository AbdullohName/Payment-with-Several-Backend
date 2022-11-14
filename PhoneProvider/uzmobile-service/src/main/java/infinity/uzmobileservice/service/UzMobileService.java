package infinity.uzmobileservice.service;


import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;

public interface UzMobileService {
    ResponseDto<String> payment(PaymentDto paymentDto);
    ResponseDto<String> rollBackPayment(Long id);
}
