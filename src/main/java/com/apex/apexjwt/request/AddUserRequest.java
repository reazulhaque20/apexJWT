package com.apex.apexjwt.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddUserRequest {
    private String userId;
    private String userName;
    private String firstName;
    private String designation;
    private String department;
    private String reportingTo;
    private String mobile;
    private String extNo;
    private String email;
    private String lastName;
    private String roleName;
}
