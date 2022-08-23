package com.local.webservice.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String libelle;

    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @JsonIgnore
    private Collection<Article> articles;

    public void addArticle(Article article){
        articles.add(article);
        article.setCategory(this);
    }

    public void removeArticle(Article article){
        articles.remove(article);
        article.setCategory(null);
    }
    

}
