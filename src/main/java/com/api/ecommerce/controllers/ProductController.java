package com.api.ecommerce.controllers;

import com.api.ecommerce.DTOs.ProductDto;
import com.api.ecommerce.Interfaces.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/product")
public class ProductController {
    @Autowired
    private IProduct productService;

    @GetMapping("/getAll")
    public List<ProductDto> getAll(){ return productService.findAll(); }

    @GetMapping("/getById/{id}")
    public ResponseEntity<?> getById(@PathVariable UUID id) throws DataAccessException {
        ProductDto productDto = null;
        Map<String, Object> response = new HashMap<>();
        productDto = productService.findById(id);
        if(productDto==null){
            response.put("mensaje", "Registro no encontrado");
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ProductDto>(productDto,HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody ProductDto data) throws DataAccessException {
        ProductDto productDto = null;
        productDto = productService.save(data);
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable UUID id, @RequestBody ProductDto data)
            throws DataAccessException{
        ProductDto productDto = null;
            Map<String, Object> response = new HashMap<>();
            if(( productDto = productService.findById(id))==null) {
                response.put("mensaje", "Registro no encontrado");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }
            productDto.setName(data.getName());
            productDto.setCategory(data.getCategory());
            productDto.setDescription(data.getDescription());
            productDto.setPrice(data.getPrice());
            productDto = productService.save(productDto);
        return new ResponseEntity<ProductDto>(productDto, HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable UUID id) throws DataAccessException {
        Map<String, Object> response = new HashMap<>();
        productService.deleteById(id);
        response.put("mensaje", "Se ha eliminado el registro con exito");
        return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
    }
}
