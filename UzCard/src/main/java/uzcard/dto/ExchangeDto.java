package uzcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ExchangeDto {
    @Size(min = 13,max = 13,message = "PhoneNumber Length Must be 13")
    private String phoneNumber;
    private List<String> cardNumber;
}
