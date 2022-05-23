package com.apex.apexjwt.service;

import com.apex.apexjwt.dao.UserInfoDAO;
import com.apex.apexjwt.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserInfoServiceImpl implements UserInfoService{

    private final UserInfoDAO userInfoDAO;

    @Override
    public UserInfo findByUserId(String userId) {
        return userInfoDAO.findUserInfoByUserId(userId);
    }
}
