package com.apex.apexjwt.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordRequest {

    private String userName;
    private String currentPassword;
    private String newPassword;
    private String confirmPassword;
}
