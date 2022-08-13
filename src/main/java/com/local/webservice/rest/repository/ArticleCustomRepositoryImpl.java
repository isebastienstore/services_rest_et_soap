package com.local.webservice.rest.repository;

import com.local.webservice.rest.model.Article;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ArticleCustomRepositoryImpl implements ArticleCustomRepository{

    @Autowired
    private EntityManager entityManager;


    @Override
    public List<Article> findByCategory(final String category) {
        String sql = "SELECT a FROM Article a WHERE a.category.libelle=:category";

        final TypedQuery<Article> query = entityManager.createQuery(sql, Article.class);
        query.setParameter("category", category);
        return query.getResultList();
    }

    @Override
    public int deletebyCategory(String category) {
        String sql = "DELETE FROM Article a WHERE a.category.libelle=:category";

        final TypedQuery<Article> query = entityManager.createQuery(sql, Article.class);
        query.setParameter("category", category);
        return query.executeUpdate();
    }

}
