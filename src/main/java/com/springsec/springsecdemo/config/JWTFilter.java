package com.springsec.springsecdemo.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JWTFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Here you would typically extract the JWT from the request header,
        // validate it, and set the authentication in the security context.
        // For simplicity, this example does not implement JWT validation.

        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String jwtToken = authHeader.substring(7); // Extract the token
            // Validate the token and set authentication in the security context
            // This part is omitted for brevity
        }

        filterChain.doFilter(request, response); // Continue with the filter chain
    }
}
