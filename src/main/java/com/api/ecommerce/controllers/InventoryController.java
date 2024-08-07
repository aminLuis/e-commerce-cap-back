package com.api.ecommerce.controllers;

import com.api.ecommerce.DTOs.InventoryDto;
import com.api.ecommerce.DTOs.ProductDto;
import com.api.ecommerce.Interfaces.IInventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private IInventory inventoryService;

    @GetMapping("/getAll")
    public List<InventoryDto> getAll() { return inventoryService.findAll(); }

    @PostMapping("/findByProduct")
    public ResponseEntity<?> findByProduct(@RequestBody ProductDto productDto) {
        InventoryDto inventoryDto = null;
        Map<String, Object> response = new HashMap<>();
        inventoryDto = inventoryService.findByProduct(productDto);
        if(inventoryDto == null) {
            response.put("mensaje", "Registro no encontrado");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<InventoryDto>(inventoryDto, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody InventoryDto data) throws DataAccessException {
        InventoryDto inventoryDto = null;
        inventoryDto = inventoryService.save(data);
        return new ResponseEntity<InventoryDto>(inventoryDto, HttpStatus.OK);
    }
}
