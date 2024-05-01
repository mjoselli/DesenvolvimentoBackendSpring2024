package com.pucpr.exercicio.auth;

import com.pucpr.exercicio.entity.MyUserDetails;
import com.pucpr.exercicio.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    public User getUser() {
        return ((MyUserDetails)getAuthentication().getPrincipal()).getUser();
    }
}
