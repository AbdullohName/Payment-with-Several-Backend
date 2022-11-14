//package uzcard.configuration;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import uzcard.service.Impl.UserService;
//
//@Configuration  @EnableGlobalAuthentication  @EnableGlobalMethodSecurity(prePostEnabled = true)  @RequiredArgsConstructor
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//    private final UserService userService;
//    private final PasswordEncoder encoder;
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .authorizeRequests()
//                .antMatchers("/uzcard/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(provider());
//    }
//    private DaoAuthenticationProvider provider(){
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(encoder);
//        provider.setUserDetailsService(userService);
//        return provider;
//    }
//}
