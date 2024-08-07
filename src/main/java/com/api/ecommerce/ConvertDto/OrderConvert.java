package com.api.ecommerce.ConvertDto;

import com.api.ecommerce.DTOs.OrderDto;
import com.api.ecommerce.entities.OrderEntity;

public class OrderConvert {
    CustomerConvert customerConvert = new CustomerConvert();
    public OrderDto orderEntityToDto(OrderEntity orderEntity) {
        OrderDto orderDto = new OrderDto();
        orderDto.setId(orderEntity.getId());
        orderDto.setOrderDate(orderEntity.getOrderDate());
        orderDto.setCustomer(customerConvert.customerEntityToDto(orderEntity.getCustomer()));
        /*orderDto.getCustomer().setEmail(orderEntity.getCustomer().getEmail());
        orderDto.getCustomer().setName(orderEntity.getCustomer().getName());
        orderDto.getCustomer().setId(orderEntity.getCustomer().getId());
        orderDto.getCustomer().setAddress(orderEntity.getCustomer().getAddress());*/
        return orderDto;
    }

    public OrderEntity orderDtoToEntity(OrderDto orderDto) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(orderDto.getId());
        orderEntity.setOrderDate(orderDto.getOrderDate());
        orderEntity.setCustomer(customerConvert.customerDtoToEntity(orderDto.getCustomer()));
        /*orderEntity.getCustomer().setId(orderDto.getCustomer().getId());
        orderEntity.getCustomer().setName(orderDto.getCustomer().getName());
        orderEntity.getCustomer().setAddress(orderDto.getCustomer().getAddress());
        orderEntity.getCustomer().setEmail(orderDto.getCustomer().getEmail());*/
        return orderEntity;
    }
}
