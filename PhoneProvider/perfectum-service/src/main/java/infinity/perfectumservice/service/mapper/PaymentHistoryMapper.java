package infinity.perfectumservice.service.mapper;


import infinity.perfectumservice.model.entity.Perfectum;
import infinity.perfectumservice.model.entity.PerfectumHistory;

public class PaymentHistoryMapper {
    public static PerfectumHistory toEntity(Perfectum information, Long id) {
        PerfectumHistory paymentHistory = new PerfectumHistory();
        paymentHistory.setFullName(information.getFullName());
        paymentHistory.setPhoneNumber(information.getPhoneNumber());
        paymentHistory.setMoneyPaid(information.getAccount());
        paymentHistory.setTransAcId(id);
        paymentHistory.setPassportNumber(information.getPassportNumber());
        return paymentHistory;
    }
}
