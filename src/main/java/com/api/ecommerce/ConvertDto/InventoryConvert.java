package com.api.ecommerce.ConvertDto;

import com.api.ecommerce.DTOs.InventoryDto;
import com.api.ecommerce.entities.InventoryEntity;

public class InventoryConvert {
    ProductConvert productConvert = new ProductConvert();
    public InventoryDto inventoryEntityToDto(InventoryEntity inventoryEntity) {
        InventoryDto inventoryDto = new InventoryDto();
        inventoryDto.setId(inventoryEntity.getId());
        inventoryDto.setProduct(productConvert.productEntityToDto(inventoryEntity.getProduct()));
        inventoryDto.setQuantity(inventoryEntity.getQuantity());
        return inventoryDto;
    }

    public InventoryEntity inventoryDtoToEntity(InventoryDto inventoryDto) {
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setId(inventoryDto.getId());
        inventoryEntity.setProduct(productConvert.productoDtoToEntity(inventoryDto.getProduct()));
        inventoryEntity.setQuantity(inventoryDto.getQuantity());
        return inventoryEntity;
    }
}
