package com.apex.apexjwt.dao;

import com.apex.apexjwt.model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentDAO extends CrudRepository<Department, Long> {

    @Query("SELECT u FROM Department u WHERE u.deptName=:deptName")
    Department findDepartmentByName(@Param("deptName") String deptName);

    @Query("SELECT u FROM Department u WHERE u.isEnable=true")
    List<Department> findAllActiveDepartment();
}
