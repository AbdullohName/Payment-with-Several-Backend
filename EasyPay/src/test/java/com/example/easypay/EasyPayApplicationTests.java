package com.example.easypay;
//
import com.example.easypay.service.Impl.UserService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.webjars.NotFoundException;
//
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
@SpringBootTest
class EasyPayApplicationTests {
    @Autowired
    private UserService userService;
//
    @Test
    void contextLoads() {
    }
//    @Test
//    @DisplayName("Check NumberUtil to parse object to Long")
//    void CheckParseToLong() {
//        Object object = "124";
//        Long expect = 124L;
//        Long result = Long.parseLong(String.valueOf(object));
//        Assertions.assertEquals(expect,result);
//    }
//    @Test
//    @DisplayName("Check user which doesn't have locale")
//    void when_username_provided_than_check_given_user_is_correct() {
//        String username = "abdulloh";
//        assertThrows(NotFoundException.class,() -> userService.loadUserByUsername(username),"Locale for user is not found");
//
//    }
//
//    @Test
//    @DisplayName("Check User which not exists")
//    void username_not_found_test() {
//        String username = UUID.randomUUID().toString();
//        assertThrows(UsernameNotFoundException.class,() -> userService.loadUserByUsername(username),"UserService works incorrectly");
    }
//
//}
