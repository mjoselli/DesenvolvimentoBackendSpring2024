package com.pucpr.exercicio.repository;

import com.pucpr.exercicio.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository  extends JpaRepository<Inventory, Long> {
}
