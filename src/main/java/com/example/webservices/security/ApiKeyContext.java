package com.example.webservices.security;

import com.example.webservices.security.Permission;
import java.util.Set;


public final class ApiKeyContext {

    private static final ThreadLocal<Set<Permission>> CONTEXT = new ThreadLocal<>();

    private ApiKeyContext() {}

    public static void set(Set<Permission> permissions) {
        CONTEXT.set(permissions);
    }

    public static Set<Permission> get() {
        return CONTEXT.get();
    }

    public static void clear() {
        CONTEXT.remove();
    }
}
