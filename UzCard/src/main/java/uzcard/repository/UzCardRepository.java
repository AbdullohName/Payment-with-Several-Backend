package uzcard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uzcard.entity.UzCard;

import java.util.List;

@Repository
public interface UzCardRepository extends JpaRepository<UzCard, Integer> {
//    @Modifying
    @Query(value = "select u from UzCard u where u.cardNumber = :cardNumber AND u.phoneNumber = :phoneNumber AND u.sms = true ")
    UzCard findAllByPhoneNumberAndSms(@Param("cardNumber") String cardNumber,@Param("phoneNumber") String phoneNumber);

    @Query("select count(u) from UzCard u")
    Integer countCard();

    @Query(value = "select count(u) from UzCard u where u.passportId = ?1")
    Integer countCardByPassportId(Integer id);
    UzCard findByCardNumber(String cardNumber);

    @Query(value = "select u from UzCard u where u.cardNumber = :cardNumber and u.sms = true")
    UzCard findAllByCardNumberAndSms(@Param("cardNumber")String cardNumber);
}