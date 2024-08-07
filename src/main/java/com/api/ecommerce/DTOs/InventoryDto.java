package com.api.ecommerce.DTOs;

import com.api.ecommerce.entities.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDto {
    private UUID id;

    private ProductDto product;

    private Integer quantity;
}
