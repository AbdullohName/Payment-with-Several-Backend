package com.example.easypay.service.mapper;

import com.example.easypay.dto.UserInfoDto;
import com.example.easypay.entity.Authorities;
import com.example.easypay.entity.Users;
import org.mapstruct.Mapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Mapper(componentModel = "spring")
public interface UserMapper {
    Users toEntity(UserInfoDto dto);
    UserInfoDto toDto(Users users);
    default SimpleGrantedAuthority convert(Authorities authorities) {
        return new SimpleGrantedAuthority(authorities.getName());
    }
//    @Mapping(target = "permission",source = "authorities")
}
