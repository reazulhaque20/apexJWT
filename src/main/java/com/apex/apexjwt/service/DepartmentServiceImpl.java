package com.apex.apexjwt.service;

import com.apex.apexjwt.dao.DepartmentDAO;
import com.apex.apexjwt.model.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private final DepartmentDAO departmentDAO;

    @Override
    public Department findDepartmentByName(String deptName) {
        return departmentDAO.findDepartmentByName(deptName);
    }

    @Override
    public List<Department> findAllActiveDepartment() {
        return departmentDAO.findAllActiveDepartment();
    }
}
