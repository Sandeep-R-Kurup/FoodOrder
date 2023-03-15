package com.SandeepRKurup.FoodMCT.controller;



import com.SandeepRKurup.FoodMCT.dao.foodRepository;
import com.SandeepRKurup.FoodMCT.dao.orderRepository;
import com.SandeepRKurup.FoodMCT.dao.userRepository;
import com.SandeepRKurup.FoodMCT.model.order;
import com.SandeepRKurup.FoodMCT.service.orderService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class orderController {
    @Autowired
    userRepository userrepository;
    @Autowired
    foodRepository foodrepository;
    @Autowired
    orderRepository orderrepository;
    @Autowired
    orderService orderService;
    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestBody String orderrequest){
        JSONObject errorList=orderService.validateOrder(orderrequest);
        if(!errorList.isEmpty()){
            return new ResponseEntity<>(errorList.toString(), HttpStatus.BAD_REQUEST);
        }
        else{
            order order1=orderService.setOrder(orderrequest);
            order order2=orderrepository.save(order1);
            return new ResponseEntity<>("order placed and orderid is "+order2.getOrderId(),HttpStatus.OK);
        }
    }

    @GetMapping("/getOrder")
    public ResponseEntity<String> getOrder(@Nullable @RequestParam String orderId){
        List<order> orders=new ArrayList<>();
        if(orderId==null){
            orders=orderrepository.findAll();
        }
        else{
            order order1=orderrepository.findById(Integer.valueOf(orderId)).get();
            orders.add(order1);
        }
        return new ResponseEntity<>(orders.toString(),HttpStatus.OK);
    }
}