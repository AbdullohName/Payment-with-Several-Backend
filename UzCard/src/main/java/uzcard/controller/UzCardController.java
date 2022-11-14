package uzcard.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uzcard.dto.ExchangeDto;
import uzcard.dto.ResponseDto;
import uzcard.dto.UzCardDto;
import uzcard.dto.WithdrawMoneyDto;
import uzcard.service.UzCardService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@RestController @RequestMapping("/uzcard") @RequiredArgsConstructor @CrossOrigin
public class UzCardController {
    private final UzCardService service;
    @GetMapping
    public ResponseDto<List<UzCardDto>> getAllByPhoneNumber(@RequestBody @Valid ExchangeDto exchangeDto) {
        return service.getAllByPhoneNumber(exchangeDto);
    }
    @PostMapping
    public ResponseDto<Void> withdrawMoney(@RequestBody @Valid WithdrawMoneyDto drawMoney) {
        return service.withdrawMoney(drawMoney);
    }

    @PostMapping("/rollBack/{transAcId}")
    public ResponseDto<Void> rollbackPay(@PathVariable @NotNull Long transAcId) {
        return service.rollbackPay(transAcId);
    }

    @PostMapping("/checkCard")
    public ResponseDto<Void> checkCard(@RequestParam String cardNumber) {
        return service.checkCard(cardNumber);
    }

//    @GetMapping("/ziyodilla")
//    public ResponseDto<String> hello() {
//        return ResponseDto.<String>builder().code(0).message("sulaymon nima gap").success(true).data("Ziyodilla nima gap").build();
//    }
    @GetMapping
    public ResponseDto<UzCardDto> getByCardNumber(@RequestParam String cardNumber) {
        return service.getByCardNumber(cardNumber);
    }
}
