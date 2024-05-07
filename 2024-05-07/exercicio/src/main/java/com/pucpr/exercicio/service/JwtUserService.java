package com.pucpr.exercicio.service;

import com.pucpr.exercicio.entity.MyUserDetails;
import com.pucpr.exercicio.entity.User;
import com.pucpr.exercicio.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.pucpr.exercicio.dto.LoginUserDTO;

@Service
public class JwtUserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;
    
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired JwtTokenService tokenService;

    public String authenticateUser(LoginUserDTO loginUserDTO){
        UsernamePasswordAuthenticationToken token = 
                new UsernamePasswordAuthenticationToken(loginUserDTO.username(), loginUserDTO.password());
        Authentication authentication = authenticationManager.authenticate(token);
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        return tokenService.generateToken(userDetails.getUsername());
    }

    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
