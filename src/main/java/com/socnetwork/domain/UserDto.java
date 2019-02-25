package com.socnetwork.domain;

import com.socnetwork.enums.UserRoles;
import lombok.Data;

import java.util.Date;

@Data
public class UserDto {

    private String username;
    private String name;
    private String secondName;
    private String password;
    private Date birthDate;
    private String pic;
    private String phoneNumber;
    private String email;
    private UserRoles role;
    private boolean enabled;
}
