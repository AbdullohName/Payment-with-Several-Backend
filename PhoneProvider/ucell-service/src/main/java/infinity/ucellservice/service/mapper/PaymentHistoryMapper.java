package infinity.ucellservice.service.mapper;


import infinity.ucellservice.model.entity.Ucell;
import infinity.ucellservice.model.entity.UcellHistory;

public class PaymentHistoryMapper {
    public static UcellHistory toEntity(Ucell information, Long id) {
        UcellHistory paymentHistory = new UcellHistory();
        paymentHistory.setFullName(information.getFullName());
        paymentHistory.setPhoneNumber(information.getPhoneNumber());
        paymentHistory.setMoneyPaid(information.getAccount());
        paymentHistory.setTransAcId(id);
        paymentHistory.setPassportNumber(information.getPassportNumber());
        return paymentHistory;
    }
}
