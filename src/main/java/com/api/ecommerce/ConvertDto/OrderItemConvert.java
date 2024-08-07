package com.api.ecommerce.ConvertDto;

import com.api.ecommerce.DTOs.OrderItemDto;
import com.api.ecommerce.entities.OrderItemEntity;

public class OrderItemConvert {
    OrderConvert orderConvert = new OrderConvert();
    ProductConvert productConvert = new ProductConvert();
    public OrderItemDto orderItemEntityToDto(OrderItemEntity orderItemEntity) {
        OrderItemDto orderItemDto = new OrderItemDto();
        orderItemDto.setId(orderItemEntity.getId());
        orderItemDto.setPrice(orderItemEntity.getPrice());
        orderItemDto.setQuantity(orderItemEntity.getQuantity());
        orderItemDto.setOrder(orderConvert.orderEntityToDto(orderItemEntity.getOrder()));
        orderItemDto.setProduct(productConvert.productEntityToDto(orderItemEntity.getProduct()));
        return orderItemDto;
    }

    public OrderItemEntity orderItemDtoToEntity(OrderItemDto orderItemDto) {
        OrderItemEntity orderItemEntity = new OrderItemEntity();
        orderItemEntity.setId(orderItemDto.getId());
        orderItemEntity.setPrice(orderItemDto.getPrice());
        orderItemEntity.setQuantity(orderItemDto.getQuantity());
        orderItemEntity.setOrder(orderConvert.orderDtoToEntity(orderItemDto.getOrder()));
        orderItemEntity.setProduct(productConvert.productoDtoToEntity(orderItemDto.getProduct()));
        return orderItemEntity;
    }
}
