package com.local.webservice.soap.repository;

import javax.persistence.EntityManager;
import com.local.webservice.rest.model.Article;
import com.local.webservice.soap.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.TypedQuery;

public class UserCustomRepositoryImpl implements UserCustomRepository{
    @Autowired
    private EntityManager entityManager;

    @Override
    public User findByFirstName(String first_name) {
        String sql = "SELECT u FROM User u WHERE u.first_name=:first_name";

        final TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        query.setParameter("first_name", first_name);
        return query.getSingleResult();
    }

    @Override
    public User updateUser(Long id, User user) {
        String sql = "UPDATE user u\n" +
                "SET u.user_name =:user_name, u.password=:password, u.role=:role \n" +
                "WHERE u.id=:id;";
        final TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        query.setParameter("user_name", user.getUser_name());
        query.setParameter("password", user.getPassword());
        query.setParameter("role", user.getRole());
        return query.getSingleResult();
    }

    @Override
    public int deleteByFirstName(String first_name) {
        String sql = "DELETE FROM User u WHERE u.first_name=:first_name";

        final TypedQuery<User> query = entityManager.createQuery(sql, User.class);
        query.setParameter("first_name", first_name);
        return query.executeUpdate();
    }
}
