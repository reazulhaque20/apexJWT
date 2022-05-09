package com.apex.apexjwt.controller;

import com.apex.apexjwt.model.Role;
import com.apex.apexjwt.response.Response;
import com.apex.apexjwt.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    private RoleService roleService;

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
}
