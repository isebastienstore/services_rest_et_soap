package com.local.webservice.soap.soapController;

import com.local.webservice.soap.model.User;
import com.local.webservice.soap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.*;
import java.util.List;

@Component
@WebService(name = "UserWS")
public class UserWebService {
    @Autowired
    private UserService userService;

    @WebMethod(operationName = "getAllUsers")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @WebMethod(operationName = "getUsersById")
    public User getUserById(@WebParam(name = "userId") final Long id){
        return userService.getUserById(id);
    }

    public User getUserByFirstName(final String first_name){
        return userService.getUserByFirstName(first_name);
    }

    @WebMethod(operationName = "addUser")
    public String addUser(@WebParam(name = "user") User user){
        return userService.addUser(user);
    }

    public User updateUser(@WebParam(name="id") final Long id, @WebParam(name="user") final User user){
        return userService.updateUser(id, user);
    }

    @WebMethod(operationName="deleteUser")
    public void deleteUser(@WebParam(name = "user") final User user){
        userService.deleteUser(user);
    }

    @WebMethod(operationName="deleteUserByFirstName")
    public int deleteUserByFirstName(@WebParam(name = "first_name") final String first_name){
        return userService.deleteUserByFirstName(first_name);
    }


    @WebMethod(operationName = "deleteUserById")
    public String deleteUserById(@WebParam(name = "id") final Long id){
        return userService.deleteUserById(id);
    }
}
