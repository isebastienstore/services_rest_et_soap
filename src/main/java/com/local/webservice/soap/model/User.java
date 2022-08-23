package com.local.webservice.soap.model;

import lombok.Data;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom")
    private String firstName;

    @Column(name = "prenom")
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String password;

    @Column(name = "role")
    private String roleUser;

    public void setPassword(String password){
       this.password = CryptPassword.crypt(password);
    }
}
