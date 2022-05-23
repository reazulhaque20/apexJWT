package com.apex.apexjwt.controller;

import com.apex.apexjwt.model.UserInfo;
import com.apex.apexjwt.response.UserInfoResponse;
import com.apex.apexjwt.service.UserInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserInfoController {

    private final UserInfoService userInfoService;

    @GetMapping("/userInfo/{userId}")
    public UserInfoResponse getUserInfoData(@PathVariable("userId") String userId){
        UserInfo userInfo = userInfoService.findByUserId(userId);
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        if(userInfo == null){
            userInfoResponse.setMessage("ERROR WHILE GETTING USER INFO.");
        }else {
            userInfoResponse.setUserInfo(userInfo);
            userInfoResponse.setMessage("SUCCESS");
        }
        return userInfoResponse;
    }
}
