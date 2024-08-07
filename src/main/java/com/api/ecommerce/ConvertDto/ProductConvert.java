package com.api.ecommerce.ConvertDto;

import com.api.ecommerce.DTOs.ProductDto;
import com.api.ecommerce.entities.ProductEntity;

public class ProductConvert {

    CategoryConvert categoryConvert = new CategoryConvert();
    public ProductDto productEntityToDto(ProductEntity productEntity){
        ProductDto productDto = new ProductDto();
            productDto.setId(productEntity.getId());
            productDto.setName(productEntity.getName());
            productDto.setDescription(productEntity.getDescription());
            productDto.setPrice(productEntity.getPrice());
            if(productEntity.getCategory() != null) {
                productDto.setCategory(categoryConvert.categoryEntityToDto(productEntity.getCategory()));
            }
        return productDto;
    }

    public ProductEntity productoDtoToEntity(ProductDto productDto){
        ProductEntity productEntity = new ProductEntity();
            productEntity.setId(productDto.getId());
            productEntity.setName(productDto.getName());
            productEntity.setDescription(productDto.getDescription());
            productEntity.setPrice(productDto.getPrice());
            if(productDto.getCategory() != null) {
                productEntity.setCategory(categoryConvert.categoryDtoToEntity(productDto.getCategory()));
            }
        return productEntity;
    }
}
