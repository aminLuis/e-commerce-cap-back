package com.api.ecommerce.services;

import com.api.ecommerce.ConvertDto.InventoryConvert;
import com.api.ecommerce.ConvertDto.ProductConvert;
import com.api.ecommerce.DTOs.InventoryDto;
import com.api.ecommerce.DTOs.ProductDto;
import com.api.ecommerce.Interfaces.IInventory;
import com.api.ecommerce.dao.InventoryRepository;
import com.api.ecommerce.entities.InventoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class InventoryService implements IInventory {

    @Autowired
    private InventoryRepository inventoryRepository;

    InventoryConvert inventoryConvert = new InventoryConvert();

    @Override
    public List<InventoryDto> findAll() {
        List<InventoryEntity> inventoryEntities = inventoryRepository.findAll();
        List<InventoryDto> inventoryDtos = new ArrayList<>();
        for(InventoryEntity inventoryEntity: inventoryEntities) {
            inventoryDtos.add(inventoryConvert.inventoryEntityToDto(inventoryEntity));
        }
        return inventoryDtos;
    }

    @Override
    public InventoryDto findById(UUID id) {
        return null;
    }

    @Override
    public InventoryDto save(InventoryDto inventoryDto) {
        return inventoryConvert
                .inventoryEntityToDto(
                        inventoryRepository.save(
                                inventoryConvert.inventoryDtoToEntity(inventoryDto)));
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public InventoryDto findByProduct(ProductDto productDto) {
        ProductConvert productConvert = new ProductConvert();
        return inventoryConvert.inventoryEntityToDto(inventoryRepository.findByProduct(productConvert.productoDtoToEntity(productDto)));
    }
}
