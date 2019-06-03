package com.socnetwork.controllers.auth.domain;

import lombok.Data;

@Data
public class ApiResponse {

    private Boolean success;
    private String message;

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
