package com.apex.apexjwt.model;

import lombok.Data;

@Data
public class JwtRequest {

    private String userName;
    private String password;
}
