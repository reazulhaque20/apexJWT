package com.apex.apexjwt.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    private String userId;
    private String userName;
    private String designation;
    private String department;
    private String reportingTo;
    private String extNo;
    private String password;

}
