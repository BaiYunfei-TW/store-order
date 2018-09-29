package com.example.storeorder.security.filter;//package com.example.orderbackend.security.filter;

import com.example.storeorder.security.token.CustomSimpleToken;
import com.example.storeorder.security.token.Token;
import com.google.gson.Gson;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

public class AuthenticatedTokenFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String tokenString = request.getHeader("x-authenticated-token");
        if (tokenString == null) {
            filterChain.doFilter(request, response);
            return;
        }

        Gson gson = new Gson();
        Token token = gson.fromJson(tokenString, Token.class);
        CustomSimpleToken customSimpleToken = new CustomSimpleToken(token.getUsserId(), token.getRole()
                .stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList()));

        SecurityContextHolder.getContext().setAuthentication(customSimpleToken);

        filterChain.doFilter(request, response);
    }
}
