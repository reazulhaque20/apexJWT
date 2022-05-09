package com.apex.apexjwt.dao;

import com.apex.apexjwt.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface UserDAO extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.userName=:userName")
    User findUserByUserName(@Param("userName") String userName);
}
