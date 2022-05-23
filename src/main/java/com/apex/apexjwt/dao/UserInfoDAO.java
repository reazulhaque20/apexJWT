package com.apex.apexjwt.dao;

import com.apex.apexjwt.model.UserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDAO extends CrudRepository<UserInfo, Long> {

    @Query("SELECT u FROM UserInfo u WHERE u.userId=:userId")
    UserInfo findUserInfoByUserId(@Param("userId") String userId);
}
