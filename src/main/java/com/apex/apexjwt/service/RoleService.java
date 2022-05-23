package com.apex.apexjwt.service;

import com.apex.apexjwt.model.Role;

public interface RoleService {

    Role createNewRole(Role role);
    Role findRoleByRoleName(String roleName);
}
