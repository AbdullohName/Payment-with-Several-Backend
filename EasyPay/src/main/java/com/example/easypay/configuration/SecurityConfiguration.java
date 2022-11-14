package com.example.easypay.configuration;

import com.example.easypay.security.JwtEntryPoint;
import com.example.easypay.security.JwtFilter;
import com.example.easypay.service.Impl.UserService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.filters.CorsFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@CrossOrigin
@EnableGlobalAuthentication
@EnableGlobalMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
@SecurityScheme(type = SecuritySchemeType.APIKEY,name = "Authorization",in = SecuritySchemeIn.HEADER)
@OpenAPIDefinition(info = @Info(title = "Easy Pay Service",
                description = "Project for payed anything",
                termsOfService = "url",
                contact = @Contact(name = "Abdulloh Qosimov",
                                    email = "abdullohqwe@gmail.com",
                                    url = "@HackersintheWorld")),
                security = @SecurityRequirement(name = "Authorization"))
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    private final UserService usersService;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private JwtFilter jwtFilter;
    @Autowired
    private JwtEntryPoint jwtEntryPoint;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
//                .cors().configurationSource(corsConfigurationSource()).and()
////                .requiresChannel()
////                .and()
                .authorizeRequests()
                .antMatchers("/user").permitAll()
                .antMatchers("/user/**").permitAll()
                .antMatchers("/history").permitAll()
                //.antMatchers("/user/check").permitAll()
//                .antMatchers("/user/ziyodilla").permitAll()
                .antMatchers("/swagger-ui.html/**",
                                    "/swagger-ui/**",
                                    "/v3/api-docs/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
//                .httpBasic();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:8080/history"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.authenticationProvider(provider());
//                .inMemoryAuthentication()
//                .withUser("username")
//                .password(passwordEncoder.encode("password"))
//                .roles("USER")
//                .and()
//                .withUser("Faxriyor")
//                .password(passwordEncoder.encode("123"))
//                .roles("ADMIN");
    }
    private DaoAuthenticationProvider provider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(encoder);
        provider.setUserDetailsService(usersService);

        return provider;
    }


}
