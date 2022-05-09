package com.apex.apexjwt.service;

import com.apex.apexjwt.dao.RoleDAO;
import com.apex.apexjwt.dao.UserDAO;
import com.apex.apexjwt.model.Role;
import com.apex.apexjwt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    public User registerNewUser(User user){
        return userDAO.save(user);
    }

    public void initRolesAndUsers(){
        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin Role");
        adminRole = roleDAO.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("User Role");
        userRole = roleDAO.save(userRole);

        User adminUser = new User();
        adminUser.setFirstName("admin");
        adminUser.setLastName("admin");
        adminUser.setUserName("admin");
        adminUser.setPassword("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRoles(adminRoles);
        userDAO.save(adminUser);

        User user = new User();
        user.setFirstName("user");
        user.setLastName("user");
        user.setUserName("user");
        user.setPassword("user");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(userRole);
        user.setRoles(userRoles);
        userDAO.save(user);
    }
}
