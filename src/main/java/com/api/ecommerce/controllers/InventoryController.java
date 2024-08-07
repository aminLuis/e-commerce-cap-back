package com.api.ecommerce.controllers;

import com.api.ecommerce.DTOs.InventoryDto;
import com.api.ecommerce.Interfaces.IInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private IInventory inventoryService;

    @GetMapping("/getAll")
    public List<InventoryDto> getAll() { return inventoryService.findAll(); }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody InventoryDto data) throws DataAccessException {
        InventoryDto inventoryDto = null;
        inventoryDto = inventoryService.save(data);
        return new ResponseEntity<InventoryDto>(inventoryDto, HttpStatus.OK);
    }
}
