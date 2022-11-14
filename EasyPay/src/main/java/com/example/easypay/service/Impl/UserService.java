package com.example.easypay.service.Impl;

import com.example.easypay.dto.*;
import com.example.easypay.entity.UserSession;
import com.example.easypay.entity.Users;
import com.example.easypay.repository.UserSessionRepository;
import com.example.easypay.repository.UsersRepository;
import com.example.easypay.security.JwtUtil;
import com.example.easypay.service.mapper.UserMapper;
import com.example.easypay.utils.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.InvalidKeyException;
import java.util.Locale;
import java.util.Optional;

@Service @RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UsersRepository repository;
    private final UserMapper userMapper;
    private final UserSessionRepository userSessionRepository;
    private final PasswordEncoder encoder;
    private final JwtUtil jwtUtil;

    public ResponseDto<String> register(UserInfoDto userInfoDto) {
        return null;
    }

    @Override //@Transactional
    public UserDetails loadUserByUsername(String username) {
        Optional<Users> user = repository.findFirstByUsername(username);
        Optional<UserInfoDto> userInfoDto = user.map(userMapper::toDto);
        userInfoDto.ifPresent(infoDto -> Locale.setDefault(new Locale(infoDto.getLocale())));
        return userInfoDto.orElse(null);
    }
    public ResponseDto<JWTResponseDTO> login(LoginDTO loginDto) {

        Users user = repository.findFirstByUsername(loginDto.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User with username %s not found",loginDto.getUsername())));

        if(!encoder.matches(loginDto.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("Password is incorrect");
        }
        userSessionRepository.save(new UserSession(user.getId(), userMapper.toDto(user)));
        try {
            String token = jwtUtil.generateToken(String.valueOf(user.getId()));
            return ResponseDto.<JWTResponseDTO>builder()
                    .data(new JWTResponseDTO(token, DateUtil.oneDay(),null))
                    .message("ok")
                    .success(true)
                    .code(0)
                    .build();
        } catch (InvalidKeyException e) {
            return ResponseDto.<JWTResponseDTO>builder()
                    .message("Error in while generating token: " + e.getMessage())
                    .code(-2)
                    .build();
        }
    }

    public ResponseDto<UserInfoDto> checkToken(String token) {
        Long subject = Long.parseLong((String) jwtUtil.getClaim(token,"sub"));
        Optional<UserSession> userInfoDto = userSessionRepository.findById(subject);
        if(!userInfoDto.isPresent()) {
            return ResponseDto.<UserInfoDto>builder().code(-2).message("Token not found").success(false).build();
        }
        return ResponseDto.<UserInfoDto>builder()
                .code(0)
                .message("Ok")
                .data(userInfoDto.get().getUserInfoDto())
                .success(true)
                .build();
    }

    public ResponseDto<String> addUser(UserInfoDto userInfoDto) {
        try {
            Users user = userMapper.toEntity(userInfoDto);
            user.setPassword(encoder.encode(user.getPassword()));
            repository.save(user);
            return ResponseDto.<String>builder()
                    .success(true)
                    .code(0)
                    .message("OK")
                    .data("Successfully saved").build();
        } catch (Exception e) {
            return ResponseDto.<String>builder().success(false).code(-2).message("Failed").data("Failed" + e).build();
        }
    }
    public ResponseDto<UserInfoDto> update(UserInfoDto userInfoDto) {
        try {
            if(repository.existsById(userInfoDto.getId())) {
                Users users = userMapper.toEntity(userInfoDto);
                repository.save(users);
                return ResponseDto.<UserInfoDto>builder()
                        .code(0)
                        .success(true)
                        .message("Ok")
                        .data(userInfoDto).build();
            }
            return ResponseDto.<UserInfoDto>builder()
                    .code(-1)
                    .success(false)
                    .message("This user is not found")
                    .build();
        } catch (Exception e) {
            return ResponseDto.<UserInfoDto>builder()
                    .code(-3)
                    .success(false)
                    .message("Error " + e)
                    .build();
        }
    }

    public ResponseDto<String> deleteByUserName(String username) {
        try {
            repository.deleteByUsername(username);
            return ResponseDto.<String>builder()
                    .code(0)
                    .message("OK")
                    .success(true)
                    .data("Successfully deleted")
                    .build();
        } catch (Exception e) {
            return ResponseDto.<String>builder()
                    .code(-5)
                    .message("Failed")
                    .success(false)
                    .data("Failed " + e)
                    .build();
        }
    }
}
