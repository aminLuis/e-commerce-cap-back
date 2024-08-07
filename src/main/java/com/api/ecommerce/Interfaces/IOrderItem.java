package com.api.ecommerce.Interfaces;

import com.api.ecommerce.DTOs.OrderItemDto;

import java.util.List;
import java.util.UUID;

public interface IOrderItem {
    public List<OrderItemDto> findAll();

    public OrderItemDto getById(UUID id);

    public OrderItemDto save(OrderItemDto orderItemDto);

    public void deleteById(UUID id);
}
