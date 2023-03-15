package com.SandeepRKurup.FoodMCT.dao;

import com.SandeepRKurup.FoodMCT.model.food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface foodRepository extends JpaRepository<food,Integer> {
}
