package org.rahimliparviz.linkup.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.rahimliparviz.linkup.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Service
public class JwtService {

    @Value("${jwt-secret.key}")
    private String secretKey;

    public String getUsername(String jwt){
        return getClaim(jwt,
                x->x.getSubject());
    }

    public <T> T getClaim(String token, Function<Claims,T> claimsResolver){

        Claims claims = getAllClaims(token);
        return  claimsResolver.apply(claims);
    }

    public String generateToken(HashMap<String,Object> claims, User user){

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSecretKey(), SignatureAlgorithm.ES256)
                .compact();
    }

    private Claims getAllClaims(String jwt){

        return Jwts
                .parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(Base64.getDecoder().decode(secretKey));
    }
    
    public boolean isTokenValid(String token,UserDetails userDetails){
        final String username = getUsername(token);
        return (username.equals(userDetails.getUsername())) && !isTokeExpired(token);
    }

    private boolean isTokeExpired(String token) {
        return  getClaim(token,x->x.getExpiration()).before(new Date());
    }
}
