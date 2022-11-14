package uzcard.service;

import uzcard.dto.ExchangeDto;
import uzcard.dto.ResponseDto;
import uzcard.dto.UzCardDto;
import uzcard.dto.WithdrawMoneyDto;

import java.util.ArrayList;
import java.util.List;

public interface UzCardService {
    ResponseDto<List<UzCardDto>> getAllByPhoneNumber(ExchangeDto exchange);

//    ResponseDto connectWithSms
    ResponseDto<Void> withdrawMoney(WithdrawMoneyDto drawMoney);
    ResponseDto<Void> rollbackPay(Long transacId);
    ResponseDto<Void> checkCard(String cardNumber);
    ResponseDto<UzCardDto> getByCardNumber(String cardNumber);
}
