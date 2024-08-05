package com.api.ecommerce.Interfaces;

import com.api.ecommerce.DTOs.ProductDto;

import java.util.List;
import java.util.UUID;

public interface IProduct {
    public List<ProductDto> findAll();

    public ProductDto findById(UUID id);

    public ProductDto save(ProductDto product);

    public void deleteById(UUID id);
}
