package com.apex.apexjwt.service;

import com.apex.apexjwt.dao.RoleDAO;
import com.apex.apexjwt.dao.UserDAO;
import com.apex.apexjwt.model.Role;
import com.apex.apexjwt.model.User;
import com.apex.apexjwt.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserDAO userDAO;
    private final RoleDAO roleDAO;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User registerNewUser(User user, String roleReq) {
        Role role = roleDAO.findRoleByRoleName(roleReq);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);
        user.setPassword(getEncodedPassword(user.getPassword()));
        return userDAO.save(user);
    }

    @Override
    public String changepassword(User user) {
        userDAO.save(user);
        return "SUCCESS";
    }


    @Override
    public List<User> findUserList() {
        return userDAO.findUserList();
    }

    @Override
    public String getEncodedPassword(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public Response updateUser(User user) {
        Response response = new Response();
        User userToUpdate = userDAO.findUserByUsername(user.getUserName());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setDesignation(user.getDesignation());
        userToUpdate.setDepartment(user.getDepartment());
        userToUpdate.setWorkLocation(user.getWorkLocation());
        userToUpdate.setCompany(user.getCompany());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setMobile(user.getMobile());
        userToUpdate.setJoiningDate(user.getJoiningDate());

        userDAO.save(userToUpdate);

        response.setMessage("User Update Successful.");

        return response;
    }

    @Override
    public List<User> getReportingUser(String deptName) {
        return userDAO.getReportingUser(deptName);
    }

    @Override
    public User findUserByUserId(String userId) {
        return userDAO.findUserByUserId(userId);
    }

    @Override
    public Response addUser(User user, String roleName) {
        Response response = new Response();
        Set<Role> roles = new HashSet<>();
        Role role = roleDAO.findRoleByRoleName(roleName);
        roles.add(role);
        user.setRoles(roles);
        userDAO.save(user);
        response.setMessage("SUCCESS");
        return response;
    }
}
