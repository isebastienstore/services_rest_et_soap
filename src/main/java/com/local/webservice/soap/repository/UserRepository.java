package com.local.webservice.soap.repository;

import com.local.webservice.soap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserCustomRepository {}
