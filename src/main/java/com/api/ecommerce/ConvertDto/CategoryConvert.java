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
        if(categoryEntity.getProducts() != null) {
            List<ProductDto> productDtos = new ArrayList<>();
            for (ProductEntity productEntity : categoryEntity.getProducts()) {
                productDtos.add(productConvert.productEntityToDto(productEntity));
            }
            categoryDto.setProducts(productDtos);
        }
        return categoryDto;
    }

    public CategoryEntity categoryDtoToEntity(CategoryDto categoryDto){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(categoryDto.getId());
        categoryEntity.setName(categoryDto.getName());
        if(categoryDto.getProducts() != null) {
            List<ProductEntity> productEntities = new ArrayList<>();
            for (ProductDto productDto : categoryDto.getProducts()) {
                productEntities.add(productConvert.productoDtoToEntity(productDto));
            }
            categoryEntity.setProducts(productEntities);
        }
        return categoryEntity;
    }
}
