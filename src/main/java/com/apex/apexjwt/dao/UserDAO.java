package com.apex.apexjwt.dao;

import com.apex.apexjwt.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {
}
