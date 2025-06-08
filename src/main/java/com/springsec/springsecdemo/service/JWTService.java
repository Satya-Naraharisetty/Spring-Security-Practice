package com.springsec.springsecdemo.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;

@Service
public class JWTService {

//    private static final String SECRET = "your-256hsbchsbcijabweyfh736287rtgyufb";

    private String secretKey;

    public  JWTService() {
        secretKey = generateSecretKey();
    }

    public String generateSecretKey(){
        try{
            KeyGenerator keyGen = KeyGenerator.getInstance("HmacSHA256");
            SecretKey secretKey = keyGen.generateKey();
            System.out.println("Generated Secret Key: " + secretKey);
            return Base64.getEncoder().encodeToString(secretKey.getEncoded());
        }
        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error generating secret key", e);
        }
    }

    public String generateToken(String username) {
        HashMap<String, Object> claims = new HashMap<>();
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 3)) // Token valid for 3 minutes
                .signWith(getKey(), SignatureAlgorithm.HS256) // Use a secure key in production
                .compact();
    }

    private Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey); // Replace with your base64 encoded secret key
        return Keys.hmacShaKeyFor(keyBytes); // Generate a secure key
    }
}
