package com.example.webservices.config;

import com.example.webservices.security.ApiKeyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    public FilterRegistrationBean<ApiKeyFilter> apiKeyFilter() {

        FilterRegistrationBean<ApiKeyFilter> registration =
                new FilterRegistrationBean<>();

        registration.setFilter(new ApiKeyFilter());
        registration.addUrlPatterns("/weather/*");
        registration.setOrder(1);

        return registration;
    }
}
