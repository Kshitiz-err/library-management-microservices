package com.microservice.authservice.service.impl;

import com.microservice.authservice.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${JWT_SECRET}")
    private String jwtSecret;
    @Override
    public Key getSignKey() {
        byte[] decode = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(decode);
    }

    @Override
    public String generateToken(UserDetails userDetails) {
        Map<String,Object> claims = new HashMap<>();
        claims.put("Role",userDetails.getAuthorities());
        return generateToken(claims,userDetails);
    }

    private String generateToken(Map<String, Object> claims,UserDetails userDetails) {
        return Jwts.builder()
                .claims().add(claims)
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis()+1000*10*60))
                .and()
                .signWith(getSignKey())
                .compact();
    }

    @Override
    public String extractUsername(String token) {
        return extractClaims(token,Claims::getSubject);
    }

    @Override
    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername())&&isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return getExpirationDate(token).before(new Date());
    }

    private Date getExpirationDate(String token) {
        return extractClaims(token,Claims::getExpiration);
    }

    private <T>T extractClaims(String token,Function <Claims,T> claimResolver) {
        Claims claim=extactAllClaims(token);
        return claimResolver.apply(claim);
    }

    private Claims extactAllClaims(String token) {
        return Jwts.parser()
                .setSigningKey(getSignKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

}
