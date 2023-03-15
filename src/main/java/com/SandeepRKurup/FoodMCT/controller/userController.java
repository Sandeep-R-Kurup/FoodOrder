package com.SandeepRKurup.FoodMCT.controller;


import com.SandeepRKurup.FoodMCT.dao.userRepository;
import com.SandeepRKurup.FoodMCT.model.user;
import com.SandeepRKurup.FoodMCT.service.userService;
import com.SandeepRKurup.FoodMCT.utill.CommonUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class userController {
    @Autowired
    userService service;
    @Autowired
    userRepository repository;

    public boolean validateAdmin(String userName, String password) {
        List<user> userList=repository.getUser(userName,password);
        if(userList.isEmpty()){
            return false;
        }
        else{
            user user1=userList.get(0);
            boolean admin=user1.isAdmin();
            return admin;
        }
    }

    @PostMapping("/createUser")
    public ResponseEntity<String> createUser(@RequestBody String userRequest){
        JSONObject errorList=service.isValidated(userRequest);
        user user1=null;
        if(!errorList.isEmpty()){
            return new ResponseEntity<>(errorList.toString(), HttpStatus.BAD_REQUEST);
        }
        else{
            user1=service.saveUser(userRequest);
            int userId=user1.getUserId();
            return new ResponseEntity<>("user created successfully , id "+userId,HttpStatus.OK);
        }

    }
    @GetMapping("/getUser")
    public ResponseEntity<String> getuser(){
        List<user> users=repository.findAll();
        return new ResponseEntity<>(users.toString(),HttpStatus.OK);
    }



}

