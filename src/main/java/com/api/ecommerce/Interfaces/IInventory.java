package com.api.ecommerce.Interfaces;

import com.api.ecommerce.DTOs.InventoryDto;
import com.api.ecommerce.DTOs.ProductDto;

import java.util.List;
import java.util.UUID;

public interface IInventory {
    public List<InventoryDto> findAll();

    public InventoryDto findById(UUID id);

    public InventoryDto save(InventoryDto inventoryDto);

    public void deleteById(UUID id);

    public InventoryDto findByProduct(ProductDto productDto);
}
