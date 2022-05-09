package com.apex.apexjwt.service;

import com.apex.apexjwt.dao.RoleDAO;
import com.apex.apexjwt.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDAO roleDAO;

    public Role createNewRole(Role role){
        return roleDAO.save(role);
    }
}
