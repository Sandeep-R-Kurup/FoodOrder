package com.SandeepRKurup.FoodMCT.service;

import com.SandeepRKurup.FoodMCT.dao.foodRepository;
import com.SandeepRKurup.FoodMCT.dao.userRepository;
import com.SandeepRKurup.FoodMCT.model.food;
import com.SandeepRKurup.FoodMCT.model.order;
import com.SandeepRKurup.FoodMCT.model.user;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {
    @Autowired
    userRepository userrepository;
    @Autowired
    foodRepository foodrepository;
    public order setOrder(String orderrequest){
        JSONObject jsonObject=new JSONObject(orderrequest);
        order order1=new order();
        String userId= jsonObject.getString("userId");
        user user1=userrepository.findById(Integer.valueOf(userId)).get();
        order1.setUserId(user1);
        String foodId= jsonObject.getString("foodId");
        food food1=foodrepository.findById(Integer.valueOf(foodId)).get();
        order1.setFoodId(food1);
        return order1;
    }
    public JSONObject validateOrder(String orderrequest) {
        JSONObject object=new JSONObject(orderrequest);
        JSONObject errorList=new JSONObject();
        if(!object.has("userId")){
            errorList.put("userId","missing parameter");
        }
        else {
            String userId = object.getString("userId");
            user user1=userrepository.findById(Integer.valueOf(userId)).get();
            if(user1==null){
                errorList.put("userId","User by userId does not exists");
            }
        }
        if(!object.has("foodId")){
            errorList.put("foodId","missing parameter");
        }
        else {
            String foodId = object.getString("foodId");
            food food1=foodrepository.findById(Integer.valueOf(foodId)).get();
            if(food1==null){
                errorList.put("foodId","Food item does not exists");
            }
        }
        return errorList;
    }
}
