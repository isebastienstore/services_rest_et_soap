package com.local.webservice.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "titre")
    private String title;
    @Column(name = "contenu", length = 5000)
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation", nullable = false)
    private Date createdDate;

    @PrePersist
    private void onCreate(){
        createdDate = new Date();
    }


/*
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String dateCreation;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private String dateModification;

 */

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "category_id")
    private Category category;

    @Override
    public String toString(){
        return title+" : "+content;
    }

}
