package com.local.webservice.rest.repository;

import com.local.webservice.rest.model.Category;

public interface CategoryCustomRepository {
    public Category findByName(String category);
}
