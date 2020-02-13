package com.auth.serviceone.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("services")
public class ServiceController {

    @Value("${eureka.instance.instance-id}")
    private String instance;

    @GetMapping("hello")
    public String sayHello() {
        return "Hello, i'm " + instance;
    }

    @GetMapping("user")
    @PreAuthorize("hasRole('ADMIN')")
    public String getUserAuthenticated(OAuth2Authentication authentication) {
        return authentication.getUserAuthentication().getName();
    }
}
