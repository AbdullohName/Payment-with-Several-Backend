package infinity.mobiuzservice.service.mapper;


import infinity.mobiuzservice.model.entity.MobiUz;
import infinity.mobiuzservice.model.entity.MobiUzHistory;


public class PaymentHistoryMapper {
    public static MobiUzHistory toEntity(MobiUz information, Long id) {
        MobiUzHistory paymentHistory = new MobiUzHistory();
        paymentHistory.setFullName(information.getFullName());
        paymentHistory.setPhoneNumber(information.getPhoneNumber());
        paymentHistory.setMoneyPaid(information.getAccount());
        paymentHistory.setTransAcId(id);
        paymentHistory.setPassportNumber(information.getPassportNumber());
        return paymentHistory;
    }
}
