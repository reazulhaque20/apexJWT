package com.apex.apexjwt.controller;

import com.apex.apexjwt.model.User;
import com.apex.apexjwt.request.AddUserRequest;
import com.apex.apexjwt.request.ChangePasswordRequest;
import com.apex.apexjwt.response.Response;
import com.apex.apexjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/logout")
    public Response logOut(){
        Response response = new Response();
        SecurityContextHolder.clearContext();

        response.setMessage("Logout");
        return response;
    }

    @GetMapping("/forAdmin")
    @PreAuthorize("hasRole('Admin')")
    public String forAdmin(){
        return "This only for admin";
    }

    @GetMapping("/forUser")
    @PreAuthorize("hasAnyRole('Admin', 'User')")
    public String forUser(){
        return "Only for User";
    }

    @GetMapping("/getAllUser")
    @PreAuthorize("hasRole('Admin')")
    public List<User> getAllUser(){
        return userService.findUserList();
    }

    @PutMapping("/updateUser")
    @PreAuthorize("hasRole('Admin')")
    public Response updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping("/getReportingUser/{deptName}")
    @PreAuthorize("hasRole('Admin')")
    public List<User> getReportingUser(@PathVariable("deptName") String deptName){
        return userService.getReportingUser(deptName);
    }

    @PostMapping("/addUser")
    @PreAuthorize("hasRole('Admin')")
    public Response addUser(@RequestBody AddUserRequest addUserRequest){
        Response response = new Response();
        User user = userService.findUserByUserId(addUserRequest.getUserId());
        if(user != null){
            response.setMessage("EXIST");
            return response;
        }
        user = new User();
        user.setUserId(addUserRequest.getUserId());
        user.setUserName(addUserRequest.getUserId());
        user.setEmpName(addUserRequest.getUserName());
        user.setFirstName(addUserRequest.getFirstName());
        user.setDesignation(addUserRequest.getDesignation());
        user.setDepartment(addUserRequest.getDepartment());
        user.setReportingTo(addUserRequest.getReportingTo());
        user.setMobile(addUserRequest.getMobile());
        user.setExtNo(addUserRequest.getExtNo());
        user.setEmail(addUserRequest.getEmail());

        response = userService.addUser(user, addUserRequest.getRoleName());

        return response;
    }


    @PostMapping("/changePassword")
    public Response changePassword(@RequestBody ChangePasswordRequest changePasswordRequest){
        Response response = new Response();

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String userName = userDetails.getUsername();
        String password = userDetails.getPassword();
        String currentPassword = changePasswordRequest.getCurrentPassword();
        boolean isPasswordMatched = passwordEncoder.matches(currentPassword, password);
        if(!isPasswordMatched){
            response.setMessage("Current Password Doesn't Match.");
            response.setMessageType("ERROR");
            return response;
        }

        User user = userService.findUserByUserId(userName);

        if(user == null){
            response.setMessage("Failed To Retrieve User Info.");
            response.setMessageType("ERROR");
            return  response;
        }

        user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));

        userService.updateUser(user);

        response.setMessage("Password Has Been Updated.");
        response.setMessageType("SUCCESS");
        return response;
    }
}
