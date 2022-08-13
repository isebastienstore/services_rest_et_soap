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

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUserById(final Long id){
        Optional<User> user = userRepository.findById(id);
        if ( user.isPresent())
            return user.get();
        else
            return null;
    }

    public User getUserByFirstName(final String first_name){
        return userRepository.findByFirstName(first_name);
    }

    public String addUser(User user){
        String message = null;
        if (userRepository.existsById(user.getId())){
            message = "L'utilisateur existe deja !";
        }
        else {
            userRepository.save(user);
            message = "Utilisateur ajouté avec succès";
        }
        return message;
    }

    public User updateUser(final Long id, final User user){
        User user1 = null;
        if(userRepository.existsById(id))
            user1 = userRepository.updateUser(id, user);
        return user1;
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    public int deleteUserByFirstName(final String first_name){
        return userRepository.deleteByFirstName(first_name);
    }

    public String deleteUserById(final Long id){
        String message = null;
        if (userRepository.existsById(id)){
            userRepository.deleteById(id);
            message = "Utilisateur supprimé avec succès !";
        }
        else {
            message = "L'utilisateur n'existe pas !";
        }
        return message;
    }
}
