package com.alnicode.todolist.web.security.filter;

import com.alnicode.todolist.domain.service.impl.CustomUserDetailsService;
import com.alnicode.todolist.web.security.JwtUtil;
import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class JwtFilterRequest extends OncePerRequestFilter {
    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer";
    private static final int BEGIN_INDEX = PREFIX.length() + 1;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    private boolean isJwt(String authorizationHeader) {
        return authorizationHeader != null && authorizationHeader.startsWith(PREFIX);
    }

    private boolean isNullAuthentication(String username) {
        return username != null && SecurityContextHolder.getContext().getAuthentication() == null;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final var authorizationHeader = request.getHeader(HEADER);

        if (isJwt(authorizationHeader)) {
            final var token = authorizationHeader.substring(BEGIN_INDEX);
            final var username = jwtUtil.extractUsername(token);

            if (isNullAuthentication(username)) {
                final var userDetails = userDetailsService.loadUserByUsername(username);

                if (jwtUtil.isValidToken(token, userDetails)) {
                    final var authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
