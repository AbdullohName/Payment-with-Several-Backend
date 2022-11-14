//package uzcard.service.Impl;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import uzcard.dto.ResponseDto;
//import uzcard.dto.UsersDto;
//import uzcard.entity.Users;
//import uzcard.service.mapper.UserMapper;
//import uzcard.repository.UserRepository;
//
//import java.util.Optional;
//
//@RequiredArgsConstructor @Service
//public class UserService implements UserDetailsService {
//    private final UserRepository repository;
//    private final UserMapper mapper;
//    private final PasswordEncoder encoder;
//
//    @Override @Transactional
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         Optional<Users> user = repository.findFirstByUsername(username);
//         Optional<UsersDto> userInfoDto = user.map(mapper::toDto);
//        return userInfoDto.orElse(null);
//    }
//
//    public ResponseDto<String> addUser(UsersDto userDto) {
//        Users user = mapper.toEntity(userDto);
//        user.setPassword(encoder.encode(user.getPassword()));
//        repository.save(user);
//        return ResponseDto.<String>builder()
//                .code(0)
//                .success(true)
//                .message("Ok").
//                data("Successfully saved").
//                build();
//    }
//}
