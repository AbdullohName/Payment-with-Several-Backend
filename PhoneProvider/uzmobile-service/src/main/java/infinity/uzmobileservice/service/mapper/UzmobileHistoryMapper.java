package infinity.uzmobileservice.service.mapper;

import infinity.uzmobileservice.model.entity.Uzmobile;
import infinity.uzmobileservice.model.entity.UzmobileHistory;

public class UzmobileHistoryMapper {
    public static UzmobileHistory toEntity(Uzmobile information, Long id) {
        UzmobileHistory paymentHistory = new UzmobileHistory();
        paymentHistory.setFullName(information.getFullName());
        paymentHistory.setPhoneNumber(information.getPhoneNumber());
        paymentHistory.setMoneyPaid(information.getAccount());
        paymentHistory.setTransAcId(id);
        paymentHistory.setPassportNumber(information.getPassportNumber());
        return paymentHistory;
    }
}
