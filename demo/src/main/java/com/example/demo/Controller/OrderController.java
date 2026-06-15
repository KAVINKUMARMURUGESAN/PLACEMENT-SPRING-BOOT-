package com.example.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.demo.DTO.OrderResponseDTO;
import com.example.demo.Service.OrderService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderservice;
    @PostMapping
    public ResponseEntity<OrderResponseDTO> createorder(@RequestHeader("X-Student-ID") String studentId){
        return orderservice.createOrder(studentId).map(OrderResponse ->new ResponseEntity<>(orderResponse.HttpStatus.CREATED));
                             .orElseGet(()->ResponseEntity.badRequest().build());
    }

}
