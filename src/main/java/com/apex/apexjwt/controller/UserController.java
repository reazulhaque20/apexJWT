package com.apex.apexjwt.controller;

import com.apex.apexjwt.model.User;
import com.apex.apexjwt.response.Response;
import com.apex.apexjwt.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void initRolesAndUsers(){
        userService.initRolesAndUsers();
    }

    @PostMapping("/registerNewUser")
    public Response registerNewUser(@RequestBody User user){
        User userCreated = userService.registerNewUser(user);
        Response response = new Response();
        if(userCreated.getId() != null){
            response.setMessage("User Created Successfully.");
        }else {
            response.setMessage("Error While Creating User!");
        }

        return response;
    }

    @GetMapping("/forAdmin")
    public String forAdmin(){
        return "This only for admin";
    }

    @GetMapping("/forUser")
    public String forUser(){
        return "Only for User";
    }
}
