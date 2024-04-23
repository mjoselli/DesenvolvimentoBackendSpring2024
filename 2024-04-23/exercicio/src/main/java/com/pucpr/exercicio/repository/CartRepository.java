package com.pucpr.exercicio.repository;

import com.pucpr.exercicio.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository
        extends JpaRepository<Cart, Long> {
}
