package com.restaurant.restaurant_management.securityConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Utility class for handling JWT operations such as token generation and validation.
 */


@Component
@RequiredArgsConstructor
public class JwtUtil {

    // Secret key string injected from application.properties
    @Value("${jwt.secret}")
    private String secret;

    // Token validity period in milliseconds (default: 10 hours)
    @Value("${jwt.expirationMs}")
    private long jwtExpirationMs;

    // HMAC-SHA key generated from the secret string
    private Key secretKey;

    /**
     * Initialize the HMAC key after Spring injects the secret string.
     */
    @PostConstruct
    public void init() {
        byte[] keyBytes = Base64.getDecoder().decode(secret);
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Generate JWT token for the authenticated user.
     * Includes username as subject and roles as a claim.
     *
     * @param userDetails Authenticated user's details
     * @return JWT token string
     */
    public String generateToken(UserDetails userDetails) {
        // Collect roles as a comma-separated string
        String authorities = userDetails.getAuthorities().stream()
                .map(auth -> auth.getAuthority())
                .collect(Collectors.joining(","));

        return Jwts.builder()
                .setSubject(userDetails.getUsername())         // Set the username as subject
                .claim("roles", authorities)                   // Add roles as claim
                .setIssuedAt(new Date())                       // Token issue time
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs)) // Expiration time
                .signWith(secretKey, SignatureAlgorithm.HS256) // Sign token with secret key and HS256
                .compact();
    }

    /**
     * Validate token by checking username and expiration.
     *
     * @param token       JWT token
     * @param userDetails User details to compare username
     * @return true if valid; false otherwise
     */
    public boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    /**
     * Extract username (subject) from JWT token.
     *
     * @param token JWT token
     * @return Username
     */
    public String extractUsername(String token) {
        return parseClaims(token).getSubject();
    }

    /**
     * Extract expiration date from JWT token.
     *
     * @param token JWT token
     * @return Expiration date
     */
    public Date extractExpiration(String token) {
        return parseClaims(token).getExpiration();
    }

    /**
     * Check if the token is expired.
     *
     * @param token JWT token
     * @return true if expired; false otherwise
     */
    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * Parse and return claims from JWT token.
     *
     * @param token JWT token
     * @return Claims object containing token data
     */
    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
