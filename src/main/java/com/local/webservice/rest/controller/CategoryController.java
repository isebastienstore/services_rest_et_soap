package com.local.webservice.rest.controller;

import com.local.webservice.rest.model.Category;
import com.local.webservice.rest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/category")
    public Iterable<Category> getAllCategory(){return categoryService.getAllCategory();}

    @GetMapping("/category/get/{id}")
    public Category getCategoryById(@PathVariable(name = "id") final int id){
        Optional<Category> category = categoryService.getCategoryById((long) id);
        if (category.isPresent())
            return category.get();
        return null;
    }

    @GetMapping("/category/{category}")
    public Category getCategoryByName(@PathVariable(name = "category")final String category){
        return categoryService.getCategorybyName(category);
    }

    @DeleteMapping("/category/delete/{id}")
    public void deleteCategoryById(@PathVariable final int id){
        categoryService.deleteCategoryById((long) id);
    }
}
