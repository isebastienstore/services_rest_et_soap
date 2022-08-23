package com.local.webservice.rest.service;

import com.local.webservice.rest.model.Category;
import com.local.webservice.rest.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Iterable<Category> getAllCategory(){return categoryRepository.findAll();}

    public Optional<Category> getCategoryById(final Long id){return categoryRepository.findById(id);}

    public Category getCategorybyName(String category){return categoryRepository.findByName(category);}

    public Category addcategory(Category category){return categoryRepository.save(category);}

    public void deleteCategory(Category category){categoryRepository.delete(category);}

    public void deleteCategoryById(final Long id){categoryRepository.deleteById(id);}
}
