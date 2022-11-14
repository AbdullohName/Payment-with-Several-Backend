package infinity.beelineservice.service.mapper;


import infinity.beelineservice.model.entity.Beeline;
import infinity.beelineservice.model.entity.BeelineHistory;

public class PaymentHistoryMapper {
    public static BeelineHistory toEntity(Beeline information, Long id) {
        BeelineHistory paymentHistory = new BeelineHistory();
        paymentHistory.setFullName(information.getFullName());
        paymentHistory.setPhoneNumber(information.getPhoneNumber());
        paymentHistory.setMoneyPaid(information.getAccount());
        paymentHistory.setTransAcId(id);
        paymentHistory.setPassportNumber(information.getPassportNumber());
        return paymentHistory;
    }
}
