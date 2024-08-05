package com.api.ecommerce.Interfaces;

import com.api.ecommerce.DTOs.CategoryDto;

import java.util.List;
import java.util.UUID;

public interface ICategory {
    public List<CategoryDto> findAll();

    public CategoryDto findById(UUID id);

    public CategoryDto save(CategoryDto category);

    public void deleteById(UUID id);
}
