package com.api.ecommerce.services;

import com.api.ecommerce.ConvertDto.ProductConvert;
import com.api.ecommerce.DTOs.ProductDto;
import com.api.ecommerce.Interfaces.IProduct;
import com.api.ecommerce.dao.ProductRepository;
import com.api.ecommerce.entities.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService implements IProduct {

    @Autowired
    private ProductRepository productRepository;

    //private ProductConvert productConvert;
    ProductConvert productConvert = new ProductConvert();
    @Override
    public List<ProductDto> findAll() {
        List<ProductEntity> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
            for(ProductEntity productEntity: products){
                productDtos.add(productConvert.productEntityToDto(productEntity));
            }
        return productDtos;
    }

    @Override
    public ProductDto findById(UUID id) {
        return productConvert.productEntityToDto(productRepository
                .findById(id).orElse(null));
    }

    @Override
    public ProductDto save(ProductDto product) {
        return productConvert
                .productEntityToDto(productRepository.save(productConvert.productoDtoToEntity(product)));
    }

    @Override
    public void deleteById(UUID id) { productRepository.deleteById(id); }
}
