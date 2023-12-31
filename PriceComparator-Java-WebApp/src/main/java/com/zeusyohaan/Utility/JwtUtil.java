package com.zeusyohaan.Utility;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "44fbaa72-c18a-4cbf-a9ff-56951c0ebe5f";
    public static String createJwtToken(String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .setExpiration(new Date(nowMillis + 3600000)) // 1-hour expiration
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static boolean authorize(String token) {
        boolean authorized = false;

        if (token != null && token.startsWith("Bearer ")) {
            String jwtToken = token.substring(7);

            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(SECRET_KEY)
                        .parseClaimsJws(jwtToken)
                        .getBody();

                Date expiration = claims.getExpiration();
                Date now = new Date();
                if (expiration != null && now.before(expiration)) {
                    authorized = true;
                }
            } catch (Exception e) {
                return authorized;
            }
        }

        return authorized;
    }
}
