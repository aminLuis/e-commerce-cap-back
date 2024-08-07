package com.api.ecommerce.DTOs;

import com.api.ecommerce.entities.OrderEntity;
import com.api.ecommerce.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {
    private UUID id;

    private OrderDto order;

    private ProductDto product;

    private Integer quantity;

    private BigDecimal price;
}
