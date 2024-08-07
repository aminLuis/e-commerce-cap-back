package com.api.ecommerce.services;

import com.api.ecommerce.ConvertDto.OrderItemConvert;
import com.api.ecommerce.DTOs.OrderItemDto;
import com.api.ecommerce.Interfaces.IOrderItem;
import com.api.ecommerce.dao.OrderItemRepository;
import com.api.ecommerce.entities.OrderItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class OrderItemService implements IOrderItem {

    @Autowired
    private OrderItemRepository orderItemRepository;

    OrderItemConvert orderItemConvert = new OrderItemConvert();

    @Override
    public List<OrderItemDto> findAll() {
        List<OrderItemEntity> ordersItem = orderItemRepository.findAll();
        List<OrderItemDto> orderItemDtos = new ArrayList<>();
        for(OrderItemEntity orderItems: ordersItem){
            orderItemDtos.add(orderItemConvert.orderItemEntityToDto(orderItems));
        }
        return orderItemDtos;
    }

    @Override
    public OrderItemDto getById(UUID id) {
        return null;
    }

    @Override
    public OrderItemDto save(OrderItemDto orderItemDto) {
        return orderItemConvert
                .orderItemEntityToDto
                        (orderItemRepository
                                .save(orderItemConvert.orderItemDtoToEntity(orderItemDto)));
    }

    @Override
    public void deleteById(UUID id) {

    }
}
