package uzcard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import uzcard.entity.UzCard;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Date;

/**
 * A DTO for the {@link UzCard} entity
 */
@Data @Builder @AllArgsConstructor @NoArgsConstructor
public class UzCardDto {
    private Integer id;
    @NotBlank(message = "Name cannot be null")
    private String fullName;
    @Size(min = 19,max = 19,message = "cardId must be 19")
    private String cardNumber;
    private Date validThru;
    @Size(min = 13,max = 13,message = "PhoneNumber should not be less than 13")
    private String phoneNumber;
    @Min(value = 0,message = "Manfiy qiymat")
    private Double balance;
    @Size(min = 9,max = 9,message = "PassportId should not be less than 9")
    private String passportId;
    @Min(value = 1000,message = "PinCode should not be less than 1000")
    private Integer pinCode;
    private Boolean sms;
    @NotBlank(message = "bankName is Empty") @NotNull
    private String bankName;
}