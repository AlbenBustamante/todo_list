package com.alnicode.todolist.domain.dto;

import lombok.Data;

@Data
public class UserResponse {
    private long id;
    private String username;
    private String role;
}
