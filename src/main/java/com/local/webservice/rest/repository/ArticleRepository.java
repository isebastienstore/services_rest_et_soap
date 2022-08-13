package com.local.webservice.rest.repository;

import com.local.webservice.rest.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>, ArticleCustomRepository {}
