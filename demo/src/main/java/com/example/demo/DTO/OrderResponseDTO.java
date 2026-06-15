package com.example.demo.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.demo.Model.OrderStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class OrderResponseDTO {
    Long id;
    BigDecimal totalAmount;
    OrderStatus status;
    private List<OrderItemDTO> items;
     @CreationTimestamp
    private LocalDateTime createdat;
    @UpdateTimestamp
    private LocalDateTime updatedat;
}
