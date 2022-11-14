package com.example.easypay.controller;

import com.example.easypay.dto.JWTResponseDTO;
import com.example.easypay.dto.LoginDTO;
import com.example.easypay.dto.ResponseDto;
import com.example.easypay.dto.UserInfoDto;
import com.example.easypay.service.Impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseDto<String> add(@RequestBody UserInfoDto userInfoDto){
        System.out.println("kirdi");
//        return ResponseDto.<String>builder().code(-3).success(false).message("FAiled").data("FAILED").build();
        return userService.addUser(userInfoDto);
    }

    @PostMapping("/login")
    public ResponseDto<JWTResponseDTO> login(@RequestBody LoginDTO loginDTO) {
        System.out.println("kirdi");
        return userService.login(loginDTO);
    }

    @GetMapping("/check")
    public ResponseDto<UserInfoDto> checkToken(@RequestParam String token){
        return userService.checkToken(token);
    }
    @GetMapping("/ziyodilla")
    public ResponseDto<String> hello() {
        return ResponseDto.<String>builder().code(0).message("sulaymon nima gap").success(true).data("Ziyodilla nima gap").build();
    }
    @PostMapping("/update")
    public ResponseDto<UserInfoDto> update(@RequestParam UserInfoDto userInfoDto) {
        return userService.update(userInfoDto);
    }

    @DeleteMapping
    public ResponseDto<String> deleteByUserName(@RequestParam @NotNull String username) {
        return userService.deleteByUserName(username);
    }
}
