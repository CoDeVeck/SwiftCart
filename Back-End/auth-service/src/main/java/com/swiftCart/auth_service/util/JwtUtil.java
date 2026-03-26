package com.swiftCart.auth_service.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;

@Component
public class JwtUtil {

    private final Key key = Keys.hmacShaKeyFor("SK_443ff638f8a74ba659cdb8336bfb5f91".getBytes());

    public String generateToken(String username, List<String> roles, String cargo, UUID uuid){
        Map<String, Object> claims = new HashMap<>();
        claims.put("roles", roles);
        claims.put("cargo",cargo);
        claims.put("uuid",uuid);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }




}
