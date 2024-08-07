package com.api.ecommerce.ConvertDto;

import com.api.ecommerce.DTOs.CategoryDto;
import com.api.ecommerce.DTOs.ProductDto;
import com.api.ecommerce.entities.CategoryEntity;
import com.api.ecommerce.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryConvert {
    @Autowired
    private ProductConvert productConvert;
    public CategoryDto categoryEntityToDto(CategoryEntity categoryEntity){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(categoryEntity.getId());
        categoryDto.setName(categoryEntity.getName());
        return categoryDto;
    }

    public CategoryEntity categoryDtoToEntity(CategoryDto categoryDto){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryDto.getId());
        categoryEntity.setName(categoryDto.getName());
        return categoryEntity;
    }
}
