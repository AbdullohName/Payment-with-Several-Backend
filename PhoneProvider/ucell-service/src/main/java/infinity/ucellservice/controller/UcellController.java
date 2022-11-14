package infinity.ucellservice.controller;

import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;

import infinity.ucellservice.service.UcellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequestMapping
public class UcellController {
    @Autowired
    private UcellService ucellService;

    @PostMapping("/beeline")
    public ResponseDto<String> payment(@RequestBody @Valid PaymentDto paymentDto) {
        System.out.println("keldi");
        return ucellService.payment(paymentDto);
    }
    @PostMapping("/rollBack")
    public ResponseDto<String> rollBackPayment(@RequestBody Long id) {
        System.out.println("rollBack");
        return ucellService.rollBackPayment(id);
    }
}
