package org.rahimliparviz.linkup.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String bearerToken=null;

        if(StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")){
            bearerToken= authHeader.substring(7, authHeader.length());
        }

        if (bearerToken != null){

        }else{
            filterChain.doFilter(request,response);
        }
    }
}