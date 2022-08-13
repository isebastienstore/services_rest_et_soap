package com.local.webservice.soap.repository;

import com.local.webservice.soap.model.User;

public interface UserCustomRepository {
    public User findByFirstName(final String first_name);

    public User updateUser(final Long id, final User user);
    public int deleteByFirstName(final String first_name);
}
