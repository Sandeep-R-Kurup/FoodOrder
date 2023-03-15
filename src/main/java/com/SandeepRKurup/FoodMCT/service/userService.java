package com.SandeepRKurup.FoodMCT.service;


import com.SandeepRKurup.FoodMCT.dao.userRepository;
import com.SandeepRKurup.FoodMCT.model.user;
import com.SandeepRKurup.FoodMCT.utill.CommonUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userService {
    @Autowired
    userRepository userRepository;
    public user setUser(String userRequest) {
        JSONObject object=new JSONObject(userRequest);
        user user1=new user();
        user1.setUserName(object.getString("userName"));
        user1.setPassword(object.getString("password"));
        user1.setFirstName(object.getString("firstName"));
        user1.setLastName(object.getString("lastName"));
        user1.setLocation(object.getString("location"));
        if(!object.has("admin")){
            user1.setAdmin(false);
        }
        else{
            boolean admin= object.getBoolean("admin");
            user1.setAdmin(admin);
        }
        return user1;
    }
    public user saveUser(String userRequest){
        user user1=setUser(userRequest);
        user createduser=userRepository.save(user1);
        return createduser;
    }
    public JSONObject isValidated(String userRequest) {
        JSONObject object=new JSONObject(userRequest);
        JSONObject errorList=new JSONObject();
        if(object.has("userName")){
            String username=object.getString("userName");
            if (!CommonUtils.isValidUsername(username)){
                errorList.put("userName","userName not valid");
            }
        }
        else{
            errorList.put("userName","missing parameter");
        }
        if(object.has("password")){
            String password=object.getString("password");
            if (!CommonUtils.isValidPassword(password)){
                errorList.put("password","Please enter valid password");
            }
        }
        if(!object.has("firstName")){
            errorList.put("firstName","missing parameter");
        }
        if(!object.has("location")){
            errorList.put("location","missing parameter");
        }
        return errorList;
    }

}
