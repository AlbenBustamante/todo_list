package com.alnicode.todolist.domain.service;

import com.alnicode.todolist.domain.dto.AuthenticationRequest;
import com.alnicode.todolist.domain.dto.UserResponse;

public interface IUserService {
    UserResponse register(AuthenticationRequest request);
}
