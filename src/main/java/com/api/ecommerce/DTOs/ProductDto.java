package com.api.ecommerce.DTOs;

import com.api.ecommerce.entities.CategoryEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private UUID id;

    private String name;

    private String description;

    private Float price;

    private CategoryDto category;
}
