package infinity.sharedlibs.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentDto {
    @Size(min = 13,max = 13)
    private String phoneNumber;

    @Min(value = 2000)
    private Double price;
    private Long transAcId;
}
