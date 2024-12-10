package org.rahimliparviz.linkup.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Base64;

@Service
public class JwtService {
    public String getUsername(String jwt){
        return "";
    }

    private Claims getAllClaims(String jwt){
        var s = Jwts
                .parser()
                .verifyWith((SecretKey)key())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
        return Jwts
                .parser()
                .verifyWith(getSecretKey())
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(Base64.getDecoder().decode("aaaaaaaaaaaaa"));
    }
}
