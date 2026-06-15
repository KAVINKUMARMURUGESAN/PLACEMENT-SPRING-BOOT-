package com.example.demo.DTO;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class OrderItemDTO {
   private Long id;
    private Long ProductId;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal subTotal;

}
