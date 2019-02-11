package com.socNetwork.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

enum UserRoles {

    @JsonProperty("admin")
    ADMIN,
    @JsonProperty("user")
    USER
}
