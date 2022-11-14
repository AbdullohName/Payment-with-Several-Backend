package com.example.easypay.dto;

import com.example.easypay.entity.Card;
import com.example.easypay.entity.HistoryPay;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;
@Data
@ToString
@JsonIgnoreProperties(value = {"password","username","cardList","authorities"},allowSetters = true,ignoreUnknown = true)
public class UserInfoDto implements UserDetails {
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String password;
    private String email;
    private Double cashBack;
    private String locale;
    private List<Card> cardList;
    private List<HistoryPay> historyList;
    private Set<SimpleGrantedAuthority> authorities;

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
