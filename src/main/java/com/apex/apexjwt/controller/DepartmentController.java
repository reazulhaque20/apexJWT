package com.apex.apexjwt.controller;


import com.apex.apexjwt.model.Department;
import com.apex.apexjwt.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/dept")
@PreAuthorize("hasRole('Admin')")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("/findByName/{deptName}")
    public Department findByName(@PathVariable("deptName") String deptName){
        return departmentService.findDepartmentByName(deptName);
    }

    @GetMapping("/findAllActive")
    public List<Department> findAllActiveDepartment(){
        return departmentService.findAllActiveDepartment();
    }
}
