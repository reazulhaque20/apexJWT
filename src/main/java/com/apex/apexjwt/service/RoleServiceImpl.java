package com.apex.apexjwt.service;

import com.apex.apexjwt.dao.RoleDAO;
import com.apex.apexjwt.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService{

    private final RoleDAO roleDAO;


    @Override
    public Role createNewRole(Role role) {
        return roleDAO.save(role);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleDAO.findRoleByRoleName(roleName);
    }
}
