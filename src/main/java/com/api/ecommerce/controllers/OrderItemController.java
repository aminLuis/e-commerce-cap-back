package com.api.ecommerce.controllers;

import com.api.ecommerce.DTOs.OrderDto;
import com.api.ecommerce.DTOs.OrderItemDto;
import com.api.ecommerce.Interfaces.IOrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderItem")
public class OrderItemController {

    @Autowired
    private IOrderItem orderItemService;

    @GetMapping("/getAll")
    public List<OrderItemDto> getAll() { return orderItemService.findAll(); }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody OrderItemDto data) throws DataAccessException {
        OrderItemDto orderItemDto = null;
        orderItemDto = orderItemService.save(data);
        return new ResponseEntity<OrderItemDto>(orderItemDto, HttpStatus.OK);
    }
}
