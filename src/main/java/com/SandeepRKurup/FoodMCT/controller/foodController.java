package com.SandeepRKurup.FoodMCT.controller;


import com.SandeepRKurup.FoodMCT.dao.foodRepository;
import com.SandeepRKurup.FoodMCT.model.food;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class foodController {
    @Autowired
    foodRepository foodRepository;
    @Autowired
    userController controller;

    @PostMapping("/createFood")
    public ResponseEntity<String> createFood(@RequestBody String foodRequest, @RequestParam String userName, @RequestParam String password){
        boolean admin= controller.validateAdmin(userName,password);
        if(admin==true){

            JSONObject object=new JSONObject(foodRequest);
            food food1=new food();
            food1.setName(object.getString("foodName"));
            food1.setType(object.getString("foodtype"));
            food food2=foodRepository.save(food1);
            return new ResponseEntity<>("food added "+food2.getFoodId(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("only admin can manage ",HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/getAllfood")
    public ResponseEntity<String> getFood(@RequestParam String userName,@RequestParam String password){
        boolean admin=controller.validateAdmin(userName,password);
        if(admin==true){
            List<food> foods=foodRepository.findAll();
            return new ResponseEntity<>(foods.toString(),HttpStatus.OK);
        }
        return new ResponseEntity<>("only admin can manage ",HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/updatefood/{foodId}")
    public ResponseEntity<String> updateFood(@PathVariable int foodId,@RequestBody String foodRequest, @RequestParam String userName,@RequestParam String password){
        boolean admin= controller.validateAdmin(userName,password);
        if(admin==true){
            JSONObject object=new JSONObject(foodRequest);
            food food1=new food();
            food1.setName(object.getString("foodName"));
            food1.setType(object.getString("foodtype"));
            food1.setFoodId(foodId);
            food food2=foodRepository.save(food1);
            return new ResponseEntity<>("food updated "+food2.getFoodId(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>("only admin can manage ",HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/deletefood")
    public ResponseEntity<String> deleteFood(@RequestParam String foodId,@RequestParam String userName,@RequestParam String password){
        boolean admin=controller.validateAdmin(userName,password);
        if(admin==true){
            foodRepository.deleteById(Integer.valueOf(foodId));
            return new ResponseEntity<>("food item at id "+foodId,HttpStatus.OK);
        }
        return new ResponseEntity<>("only admin can manage",HttpStatus.BAD_REQUEST);
    }
}
