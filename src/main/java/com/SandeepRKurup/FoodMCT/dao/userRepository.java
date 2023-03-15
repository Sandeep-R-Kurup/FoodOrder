package com.SandeepRKurup.FoodMCT.dao;

import com.SandeepRKurup.FoodMCT.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface userRepository extends JpaRepository<user,Integer> {
    @Query(value = "SELECT * from tbl_user where userName=:username and password=:Password",nativeQuery = true)
    public List<user> getUser(String username, String Password);

}
