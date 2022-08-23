package com.local.webservice.rest.repository;

import com.local.webservice.rest.model.Article;

import java.util.List;

public interface ArticleCustomRepository {
    public List<Article> findAllByCategory(final String category);
}
