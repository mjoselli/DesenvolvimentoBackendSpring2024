package com.pucpr.exercicio.repository;

import com.pucpr.exercicio.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item,Long> {
    
}
