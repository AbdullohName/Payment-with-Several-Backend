package uzcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class WithdrawMoneyDto {
    @Size(min = 19,max = 19)
    private String cardNumberTakeOff;
    @Min(value = 2000)
    private Double price;
    @Size(min = 19,max = 19)
    private String cardNumberAddMoney;
    @NotNull
    private Long transAcId;
}
