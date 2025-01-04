package com.example.user_service;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.authentication.event.LogoutSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationEventListener {

    @EventListener
    public void onAuthenticationSuccess(InteractiveAuthenticationSuccessEvent event) {
        Authentication authentication = event.getAuthentication();
        String username = authentication.getName();
        System.out.printf("EVENT: %s logged in\n", username);
    }

    @EventListener
    public void onLogoutSuccess(LogoutSuccessEvent event) {
        Authentication authentication = event.getAuthentication();
        if (authentication != null) {
            String username = authentication.getName();
            System.out.printf("EVENT: %s logged out\n", username);
        }
    }
}
