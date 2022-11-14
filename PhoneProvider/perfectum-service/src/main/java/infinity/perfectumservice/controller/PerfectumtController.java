package infinity.perfectumservice.controller;
import infinity.perfectumservice.service.PerfectumService;
import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequestMapping
public class PerfectumtController {
    @Autowired
    private PerfectumService perfectumService;

    @PostMapping("/beeline")
    public ResponseDto<String> payment(@RequestBody @Valid PaymentDto paymentDto) {
        System.out.println("keldi");
        return perfectumService.payment(paymentDto);
    }
    @PostMapping("/rollBack")
    public ResponseDto<String> rollBackPayment(@RequestBody Long id) {
        System.out.println("rollBack");
        return perfectumService.rollBackPayment(id);
    }
}
