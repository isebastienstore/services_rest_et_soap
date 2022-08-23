package com.local.webservice.soap.repository;

import com.local.webservice.soap.model.User;

public interface UserCustomRepository {
    public User findByFirstName(final String first_name);
}
