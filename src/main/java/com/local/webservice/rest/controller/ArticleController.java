package com.local.webservice.rest.controller;

import com.local.webservice.rest.model.Article;
import com.local.webservice.rest.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getArticles(){
        return articleService.getArticles();
    }


    @GetMapping("/article/{id}")
    public Article getArticleById(@PathVariable(name = "id") final Long id){
        return articleService.getArticleById(id);
    }

    @GetMapping("/articles/{category}")
    public List<Article> getArticlesyCategory(@PathVariable(name = "category") final String category){
        return articleService.getArticlesyCategory(category);
    }

    @PostMapping("/article/save")
    public Article saveArticle(@RequestBody Article article){
        return articleService.saveArticle(article);
    }

    @DeleteMapping("/article/{id}")
    public void deleteArticleById(@PathVariable(name = "id") final Long id){
        articleService.deleteArticleById(id);
    }

    @DeleteMapping("/articles/{category}")
    public int deletebyCategory(@PathVariable(name = "category") final String category) {
        return articleService.deletebyCategory(category);
    }

}
