package infinity.beelineservice.controller;

import infinity.beelineservice.service.BeelineService;
import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class BeelineController {
    @Autowired
    private BeelineService beelineService;

    @PostMapping("/beeline")
    public ResponseDto<String> payment(@RequestBody @Valid PaymentDto paymentDto) {
        System.out.println("keldi");
        return beelineService.payment(paymentDto);
    }
    @PostMapping("/rollBack")
    public ResponseDto<String> rollBackPayment(@RequestBody Long id) {
        System.out.println("rollBack");
        return beelineService.rollBackPayment(id);
    }
}
