package com.local.webservice.rest.service;

import com.local.webservice.rest.model.Article;
import com.local.webservice.rest.repository.ArticleRepository;
import com.local.webservice.soap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public Iterable<Article> getArticles(){
        return articleRepository.findAll();
    }

    public Optional<Article> getArticleById(final Long id){
         return articleRepository.findById(id);
    }

    public List<Article> getArticlesyCategory(@PathVariable(name = "category") final String category){
        return articleRepository.findAllByCategory(category);
    }

    public Article saveArticle(Article article){
        Article article1 = articleRepository.save(article);
        return article1;
    }

    public void deleteArticleById(final Long id){
        articleRepository.deleteById(id);
    }
}
