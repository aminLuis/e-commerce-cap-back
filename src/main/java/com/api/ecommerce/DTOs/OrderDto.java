package com.api.ecommerce.DTOs;

import com.api.ecommerce.entities.CustomerEntity;
import com.api.ecommerce.entities.OrderItemEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private UUID id;

    private CustomerDto customer;

    private Date orderDate;

    private List<OrderItemDto> orderItems;
    
}
