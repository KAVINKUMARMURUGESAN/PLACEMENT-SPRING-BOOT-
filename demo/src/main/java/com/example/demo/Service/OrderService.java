package com.example.demo.Service;

import org.springframework.stereotype.Service;
import com.example.demo.DTO.OrderResponseDTO;
import com.example.demo.Model.Cartitem;

import java.util.Optional;
import java.util.*;
@Service
public class OrderService {
    private final CartService cartservice;
    public Optional<OrderResponseDTO> createOrder(String studentID){
        //valitade the cart
       List<Cartitem> cartitems=cartservice.getCart(studentId);
       if(cartitems.isEmpty()){
        //
       }
       //valitade the user
    }  
}
