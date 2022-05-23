package com.apex.apexjwt.controller;

import com.apex.apexjwt.model.JwtRequest;
import com.apex.apexjwt.model.JwtResponse;
import com.apex.apexjwt.model.User;
import com.apex.apexjwt.model.UserInfo;
import com.apex.apexjwt.request.UserRequest;
import com.apex.apexjwt.response.Response;
import com.apex.apexjwt.response.UserInfoResponse;
import com.apex.apexjwt.service.JwtService;
import com.apex.apexjwt.service.UserInfoService;
import com.apex.apexjwt.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
@Log4j2
public class JwtController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping("/authenticate")
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception{
        JwtResponse jwtResponse = new JwtResponse();
        log.info("JWTRequest: "+jwtRequest);
        if(jwtRequest == null){
            jwtResponse.setMessage("User Name and Password Could Not be Empty.");
            return jwtResponse;
        }else{
            User user = jwtService.findUserByUserNameAndPassword(jwtRequest.getUserName(), jwtRequest.getPassword());
            if(user == null){
                jwtResponse.setMessage("User Name Not Found.");
                return jwtResponse;
            }else {
                if(!user.isEnable()){
                    jwtResponse.setMessage("User Not Enabled.");
                    return jwtResponse;
                }
            }
        }

        return jwtService.createJwtToken(jwtRequest);
    }

    @PostMapping("/registerNewUser")
    public Response registerNewUser(@RequestBody UserRequest userRequest){
        Response response = new Response();
        User user = userService.findUserByUserId(userRequest.getUserId());
        if(user != null){
            response.setMessage("EXIST");
            return response;
        }
        if(userRequest != null || userRequest.getUserId() != null){
            response.setMessage("ERROR");
            return response;
        }
        user.setUserId(userRequest.getUserId());
        user.setUserName(userRequest.getUserId());
        user.setEmpName(userRequest.getUserName());
        user.setDesignation(userRequest.getDesignation());
        user.setDepartment(userRequest.getDepartment());
        user.setReportingTo(userRequest.getReportingTo());
        user.setExtNo(userRequest.getExtNo());
        user.setPassword(userRequest.getPassword());
        user.setEnable(false);

        User userCreated = userService.registerNewUser(user, "User");
        if(userCreated.getId() != null){
            response.setMessage("SUCCESS");
        }else {
            response.setMessage("ERROR");
        }

        return response;
    }


    @PostMapping("/getUserInfo/{userId}")
    public UserInfoResponse getUserInfo(@PathVariable("userId") String userId){
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setUserInfo(userInfoService.findByUserId(userId));
        User user = userService.findUserByUserId(userId);

        if(user != null){
            userInfoResponse.setMessage("EXIST");
            return userInfoResponse;
        }

        if(userInfoResponse.getUserInfo() == null){
            userInfoResponse.setMessage("ERROR");
            return userInfoResponse;
        }

        userInfoResponse.setMessage("SUCCESS");

        return userInfoResponse;

    }
}
