package com.local.webservice.rest.controller;

import com.local.webservice.rest.model.Article;
import com.local.webservice.rest.model.Category;
import com.local.webservice.rest.service.ArticleService;
import com.local.webservice.rest.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/articles")
    public Iterable<Article> getArticles(){
        return articleService.getArticles();
    }


    @GetMapping("/article/{id}")
    public Article getArticleById(@PathVariable(name = "id") final Long id){
        Optional<Article> articleOptional = articleService.getArticleById(id);
        if (articleOptional.isPresent())
            return articleOptional.get();
        return null;
    }

    @GetMapping("/articles/{category}")
    public List<Article> getArticlesyCategory(@PathVariable(name = "category") final String category){
        return articleService.getArticlesyCategory(category);
    }

    @PostMapping("/article/{category}")
    public Article saveArticle(@PathVariable(name = "category") String category, @RequestBody Article article){
        Category currentCategory = categoryService.getCategorybyName(category);
        currentCategory.addArticle(article);
        return articleService.saveArticle(article);
    }

    @DeleteMapping("/article/{id}")
    public void deleteArticleById(@PathVariable(name = "id") final int id){
        articleService.deleteArticleById((long) id);
    }

    @PutMapping("/article/{id}")
    public Article updateArticle(@PathVariable(name = "id") final int id, @RequestBody Article article){
        Optional<Article> articleOptional = articleService.getArticleById((long) id);
        if(articleOptional.isPresent()) {
            Article currentArticle = articleOptional.get();

            String title = article.getTitle();
            if(title != null) {
                currentArticle.setTitle(title);
            }
            String content = article.getContent();
            if (content != null){
                currentArticle.setContent(content);
            }
            Category category = article.getCategory();
            if (category != null){
                currentArticle.setCategory(category);
            }
            Article articleUpdated = articleService.saveArticle(currentArticle);

            return articleUpdated;
        } else {
            return null;
        }
    }
}
