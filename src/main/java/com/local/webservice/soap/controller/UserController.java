package com.local.webservice.soap.controller;

import com.local.webservice.rest.model.Article;
import com.local.webservice.rest.model.Category;
import com.local.webservice.soap.model.CryptPassword;
import com.local.webservice.soap.model.User;
import com.local.webservice.soap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.*;
import java.util.List;
import java.util.Optional;

@Component
@WebService(name = "UserWS")
public class UserController {
    @Autowired
    private UserService userService;

    @WebMethod(operationName = "getAllUsers")
    public List<User> getUsers(){
        return userService.getAllUser();
    }

    @WebMethod(operationName = "getUsersById")
    public User getUserById(@WebParam(name = "userId") final Long id){
        Optional<User> user = userService.getUserById((long) id);
        if (user.isPresent())
            return user.get();
        return null;
    }

    @WebMethod(operationName = "addUser")
    public User addUser(@WebParam(name = "user") User user){
        if (user.getPassword() != null)
            user.setPassword(user.getPassword());
        return userService.addUser(user);
    }

    @WebMethod(operationName="deleteUser")
    public void deleteUser(@WebParam(name = "user") final User user){
        userService.deleteUser(user);
    }

    @WebMethod(operationName = "deleteUserById")
    public void deleteUserById(@WebParam(name = "id") final Long id){
        userService.deleteUserById((long) id);
    }

    @WebMethod(operationName = "updateUser")
    public User updateUser(@WebParam(name = "id") final int id, @WebParam(name = "user") User user){
        Optional<User> userOptional = userService.getUserById((long) id);
        if(userOptional.isPresent()) {
            User user1 = userOptional.get();

            String email = user.getEmail();
            if(email != null) {
                user1.setEmail(email);
            }
            String firstName = user.getFirstName();
            if (firstName != null){
                user1.setFirstName(firstName);
            }
            String lastName = user.getLastName();
            if (lastName != null) {
                user1.setLastName(lastName);
            }
            String roleUser = user.getRoleUser();
            if (roleUser != null) {
                user1.setRoleUser(roleUser);
            }
            String password = user.getPassword();
            if (password != null) {
                user1.setPassword(password);
            }
            return userService.addUser(user1);
        } else {
            return null;
        }
    }
}
