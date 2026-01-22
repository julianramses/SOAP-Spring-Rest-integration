package com.example.webservices.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


public final class PermissionChecker {

    public static void require(Permission permission) {
        if (!ApiKeyContext.get().contains(permission)) {
            throw new ResponseStatusException(
                    HttpStatus.FORBIDDEN,
                    "Insufficient permissions"
            );
        }
    }

    private PermissionChecker() {}
}