package com.socnetwork.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum UserRoles {

    @JsonProperty("ROLE_ADMIN")
    ADMIN,
    @JsonProperty("ROLE_STAFF")
    STAFF,
    @JsonProperty("ROLE_USER")
    USER
}
