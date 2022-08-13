package com.local.webservice.rest.model;

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

 /*   @OneToMany(
            fetch = FetchType.EAGER,
            mappedBy = "category"
    )
    private Collection<Article> articles;*/

    

}
