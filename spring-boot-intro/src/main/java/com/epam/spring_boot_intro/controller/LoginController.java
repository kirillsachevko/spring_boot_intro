package com.epam.spring_boot_intro.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class LoginController {

    @GetMapping("/user")
    public String userEndpoint(Principal principal) {
        return principal.getName();
    }

    @GetMapping("/admin")
    public String adminEndpoint(Authentication authentication) {
        return authentication.getName();
    }
}
