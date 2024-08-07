package com.api.ecommerce.controllers;

import com.api.ecommerce.DTOs.CategoryDto;
import com.api.ecommerce.Interfaces.ICategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    @Autowired
    private ICategory categoryService;

    @GetMapping("/getAll")
    public List<CategoryDto> getAll(){ return categoryService.findAll(); }
}
