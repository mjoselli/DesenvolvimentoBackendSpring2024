package com.pucpr.exercicio.repository;

import com.pucpr.exercicio.entity.Cart;
import com.pucpr.exercicio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository
        extends JpaRepository<Cart, Long> {

    public Cart findCartByActiveAndUser(boolean active, User user);
}
