//package uzcard.controller;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import uzcard.dto.ResponseDto;
//import uzcard.dto.UsersDto;
//import uzcard.service.Impl.UserService;
//
//@RestController @RequestMapping("/user") @RequiredArgsConstructor
//public class UserController {
//    private final UserService service;
//    @PostMapping
//    public ResponseDto<String> add(@RequestBody UsersDto userDto) {
//        return service.addUser(userDto);
//    }
//}
