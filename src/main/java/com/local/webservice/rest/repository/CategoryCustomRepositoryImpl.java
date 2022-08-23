package com.local.webservice.rest.repository;

import com.local.webservice.rest.model.Article;
import com.local.webservice.rest.model.Category;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;
import javax.persistence.EntityManager;

public class CategoryCustomRepositoryImpl implements CategoryCustomRepository{

    @Autowired
    private EntityManager entityManager;

    @Override
    public Category findByName(String category) {
        String sql = "SELECT c FROM Category c WHERE c.libelle=:category";

        return (Category) entityManager.createQuery(sql, Category.class)
                .setParameter("category", category)
                .getSingleResult();
    }
}
