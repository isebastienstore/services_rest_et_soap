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

    public List<Article> getArticles(){
        return articleRepository.findAll();
    }

    public Article getArticleById(final Long id){
        Optional<Article> article = articleRepository.findById(id);
        if (article.isPresent())
            return article.get();
        else
            return null;
    }

    public List<Article> getArticlesyCategory(@PathVariable(name = "category") final String category){
        return articleRepository.findByCategory(category);
    }

    public Article saveArticle(@RequestBody Article article){
        Article article1 = articleRepository.save(article);
        return article1;
    }

    public void deleteArticleById(@PathVariable(name = "id") final Long id){
        articleRepository.deleteById(id);
    }

    public int deletebyCategory(@PathVariable(name = "category") final String category) {
        return articleRepository.deletebyCategory(category);
    }
}
