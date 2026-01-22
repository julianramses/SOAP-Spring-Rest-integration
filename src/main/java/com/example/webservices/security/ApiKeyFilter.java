package com.example.webservices.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ApiKeyFilter extends OncePerRequestFilter {

    private static final String HEADER = "X-API-KEY";

    private final ApiKeyProperties properties;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain
    ) throws ServletException, IOException {

        String apiKey = request.getHeader(HEADER);
        String permissionsString =
                apiKey == null ? null : properties.getApiKeys().get(apiKey);

        if (permissionsString == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid or missing API key");
            return;
        }

        Set<Permission> permissions =
                Arrays.stream(permissionsString.split(","))
                        .map(String::trim)
                        .map(Permission::valueOf)
                        .collect(Collectors.toSet());

        ApiKeyContext.set(permissions);

        try {
            filterChain.doFilter(request, response);
        } finally {
            ApiKeyContext.clear();
        }
    }
}
