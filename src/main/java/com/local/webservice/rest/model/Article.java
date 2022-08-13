package com.local.webservice.rest.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "Article", uniqueConstraints = {
        @UniqueConstraint(name = "uc_article_categorie", columnNames = {"category_id"})
})
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String titre;
    @Column(length = 5000)
    private String contenu;

    private Timestamp dateCreation;

    private Timestamp dateModification;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    private int categorie;

    @Override
    public String toString(){
        return titre+" : "+contenu;
    }

}
