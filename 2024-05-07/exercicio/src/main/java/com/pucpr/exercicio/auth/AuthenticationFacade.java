package com.pucpr.exercicio.auth;

import com.pucpr.exercicio.entity.MyUserDetails;
import com.pucpr.exercicio.entity.User;
import com.pucpr.exercicio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {
    @Autowired
    UserRepository userRepository;
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
    public User getUser() {
        return userRepository.findByUsername(getAuthentication().getPrincipal().toString());
    }
}
