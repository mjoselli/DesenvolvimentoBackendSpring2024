package com.pucpr.exercicio.repository;

import com.pucpr.exercicio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
