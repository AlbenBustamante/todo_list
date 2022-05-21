package com.alnicode.todolist.domain.dto;

import com.alnicode.todolist.persistence.entity.Role;
import java.util.Set;
import lombok.Data;

@Data
public class UserResponse {
    private long id;
    private String username;
    private Set<Role> roles;
}
