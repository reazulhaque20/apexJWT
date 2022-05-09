package com.apex.apexjwt.dao;

import com.apex.apexjwt.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDAO extends CrudRepository<Role, Long> {
}
