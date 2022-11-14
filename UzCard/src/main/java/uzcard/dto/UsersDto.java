//package uzcard.dto;
//
//import lombok.Data;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.math.BigDecimal;
//import java.util.Collection;
//import java.util.Date;
//import java.util.Set;
//
///**
// * A DTO for the {@link } entity
// */
//@Data
//public class UsersDto implements UserDetails {
//    private Long id;
//    private String firstName;
//    private String lastName;
//    private String username;
//    private String password;
//    private String email;
//    private Date birthDate;
//    private BigDecimal account;
//    private String phoneNumber;
//    private Set<SimpleGrantedAuthority> authorities;
//
//
//    @Override
//    public String getPassword() { return password;}
//
//    @Override
//    public String getUsername() { return username; }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//}