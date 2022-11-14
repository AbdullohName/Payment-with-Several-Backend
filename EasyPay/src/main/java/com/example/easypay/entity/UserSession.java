package com.example.easypay.entity;

import com.example.easypay.dto.UserInfoDto;
import lombok.*;
import org.springframework.data.redis.core.RedisHash;

@RedisHash
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserSession {
    private Long id;
    private UserInfoDto userInfoDto;
}
