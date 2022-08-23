package com.local.webservice.soap.service;

import com.local.webservice.soap.model.User;
import com.local.webservice.soap.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(final Long id){
        return userRepository.findById(id);
    }

    public User addUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(final Long id, final User user){return null;}

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public void deleteUserById(final Long id){
        userRepository.deleteById(id);
    }
}
