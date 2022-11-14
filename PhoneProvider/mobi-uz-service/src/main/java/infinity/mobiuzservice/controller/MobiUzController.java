package infinity.mobiuzservice.controller;


import infinity.mobiuzservice.service.MobiUzService;
import infinity.sharedlibs.dto.PaymentDto;
import infinity.sharedlibs.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequestMapping
public class MobiUzController {
    @Autowired
    private MobiUzService mobiUzService;

    @PostMapping("/mobi-uz")
    public ResponseDto<String> payment(@RequestBody @Valid PaymentDto paymentDto) {
        System.out.println("keldi");
        return mobiUzService.payment(paymentDto);
    }
    @PostMapping("/rollBack")
    public ResponseDto<String> rollBackPayment(@RequestBody Long id) {
        System.out.println("rollBack");
        return mobiUzService.rollBackPayment(id);
    }
}
