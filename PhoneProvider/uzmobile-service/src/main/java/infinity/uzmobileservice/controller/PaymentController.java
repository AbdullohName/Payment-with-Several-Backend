package infinity.uzmobileservice.controller;
import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;
import infinity.uzmobileservice.service.UzMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequestMapping
public class PaymentController {
    @Autowired
    private UzMobileService uzMobileService;

    @PostMapping("/beeline")
    public ResponseDto<String> payment(@RequestBody @Valid PaymentDto paymentDto) {
        System.out.println("keldi");
        return uzMobileService.payment(paymentDto);
    }
    @PostMapping("/rollBack")
    public ResponseDto<String> rollBackPayment(@RequestBody Long id) {
        System.out.println("rollBack");
        return uzMobileService.rollBackPayment(id);
    }
}
