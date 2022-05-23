package com.apex.apexjwt.service;

import com.apex.apexjwt.model.Role;
import com.apex.apexjwt.model.User;
import com.apex.apexjwt.response.Response;
import java.util.List;

public interface UserService {

    User registerNewUser(User user, String roleReq);
    String changepassword(User user);
    List<User> findUserList();
    String getEncodedPassword(String password);
    Response updateUser(User user);
    List<User> getReportingUser(String deptName);
    User findUserByUserId(String userId);
    Response addUser(User user, String roleName);
}
