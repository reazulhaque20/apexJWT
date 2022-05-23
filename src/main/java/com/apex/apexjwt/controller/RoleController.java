package com.apex.apexjwt.controller;

import com.apex.apexjwt.model.Role;
import com.apex.apexjwt.response.Response;
import com.apex.apexjwt.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@PreAuthorize("hasRole('Admin')")
public class RoleController {

    private final RoleService roleService;

    @PostMapping({"/createNewRole"})
    public Response createNewRole(@RequestBody Role role){
        Role roleCreated = roleService.createNewRole(role);
        Response response = new Response();
        if(roleCreated.getId() != null){
            response.setMessage("Role Created Successfully.");
        }else{
            response.setMessage("Error While Creating Role.");
        }

        return response;
    }

    @GetMapping("/getRole/{roleName}")
    public Role getRole(@PathVariable("roleName") String roleName){
        return roleService.findRoleByRoleName(roleName);
    }
}
