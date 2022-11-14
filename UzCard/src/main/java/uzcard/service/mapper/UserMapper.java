//package uzcard.service.mapper;
//
//import org.mapstruct.Mapper;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import uzcard.dto.UsersDto;
//import uzcard.entity.Authorities;
//import uzcard.entity.Users;
//
//@Mapper(componentModel = "spring")
//public interface UserMapper {
//    Users toEntity(UsersDto userDto);
//    default SimpleGrantedAuthority convert(Authorities authorities) {
//        return new SimpleGrantedAuthority(authorities.getName());
//    }
////    @Mapping(target = "permissions",source = "authorities")
//    UsersDto toDto(Users users);
//}
