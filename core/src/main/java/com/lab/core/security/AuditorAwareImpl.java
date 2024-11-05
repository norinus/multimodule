package com.lab.core.security;

import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.empty();
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }

   /* @Override
    public Optional<String> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            return Optional.empty();
        }

        Object principal = authentication.getPrincipal();
        if (principal instanceof UserDetails) {
            return Optional.of(((UserDetails) principal).getUsername());
        } else {
            return Optional.of(principal.toString());
        }
    }

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }*/
}