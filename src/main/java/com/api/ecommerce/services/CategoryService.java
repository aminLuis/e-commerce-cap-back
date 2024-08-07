package com.api.ecommerce.services;

import com.api.ecommerce.ConvertDto.CategoryConvert;
import com.api.ecommerce.DTOs.CategoryDto;
import com.api.ecommerce.Interfaces.ICategory;
import com.api.ecommerce.dao.CategoryRepository;
import com.api.ecommerce.entities.CategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CategoryService implements ICategory {
    @Autowired
    private CategoryRepository categoryRepository;

    CategoryConvert categoryConvert = new CategoryConvert();

    @Override
    public List<CategoryDto> findAll() {
        List<CategoryEntity> categories = categoryRepository.findAll();
        List<CategoryDto> categoryDtos = new ArrayList<>();
        for(CategoryEntity categoryEntity: categories) {
            categoryDtos.add(categoryConvert.categoryEntityToDto(categoryEntity));
        }
        return categoryDtos;
    }

    @Override
    public CategoryDto findById(UUID id) {
        return null;
    }

    @Override
    public CategoryDto save(CategoryDto category) {
        return null;
    }

    @Override
    public void deleteById(UUID id) {

    }
}
