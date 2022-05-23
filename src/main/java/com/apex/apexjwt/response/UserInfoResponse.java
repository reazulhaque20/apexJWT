package com.apex.apexjwt.response;

import com.apex.apexjwt.model.UserInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserInfoResponse {

    private UserInfo userInfo;
    private String message;
}
