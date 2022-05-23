package com.apex.apexjwt.service;

import com.apex.apexjwt.model.UserInfo;

public interface UserInfoService {

    UserInfo findByUserId(String userId);
}
