package com.SandeepRKurup.FoodMCT.dao;

import com.SandeepRKurup.FoodMCT.model.order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<order,Integer> {
}
