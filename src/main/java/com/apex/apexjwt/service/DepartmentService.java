package com.apex.apexjwt.service;

import com.apex.apexjwt.model.Department;

import java.util.List;

public interface DepartmentService {

    Department findDepartmentByName(String deptName);
    List<Department> findAllActiveDepartment();
}
