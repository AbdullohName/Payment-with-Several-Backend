package com.example.easypay.security;

import com.example.easypay.utils.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.InvalidKeyException;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${spring.security.key}")
    private String key;

    public String generateToken(String userId) throws InvalidKeyException {
        return Jwts.builder().claim("sub",userId)
                .claim("exp", DateUtil.oneDay())
                .claim("iat",new Date())
                .signWith(SignatureAlgorithm.HS256,key)
                .compact();
    }
    public Object getClaim(String token, String name){
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody()
                .get(name);
    }
    public boolean validateToken(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
        return claims.getExpiration().after(new Date()) && claims.getSubject() != null;
    }
}
