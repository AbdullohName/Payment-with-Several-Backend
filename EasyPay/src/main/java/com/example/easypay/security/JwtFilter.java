package com.example.easypay.security;

import com.example.easypay.entity.UserSession;
import com.example.easypay.repository.UserSessionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserSessionRepository userSessionRepository;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if(authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if(jwtUtil.validateToken(token)) {
                Long id = Long.parseLong((String) jwtUtil.getClaim(token,"sub"));
                if(id != null){
                    Optional<UserSession> userSession = userSessionRepository.findById(id);
                    if(userSession.get() != null) {
                        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userSession.get().getUserInfoDto(),
                                null,
                                userSession.get().getUserInfoDto().getAuthorities());
                    WebAuthenticationDetails details = new WebAuthenticationDetailsSource().buildDetails(request);
//                        HashMap<String, String> details = new HashMap<>();
//                        details.put("address",request.getRemoteAddr());
//                        details.put("session",request.getSession().getId());
                        auth.setDetails(details);
                        SecurityContextHolder.getContext().setAuthentication(auth);
                        //SecurityContextHolder
                        //  SecurityContext
                        //      Authentication
                        //          credentials, principal, authorities, details
                    }
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
