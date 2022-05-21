package com.alnicode.todolist.domain.service.impl;

import com.alnicode.todolist.domain.dto.AuthenticationRequest;
import com.alnicode.todolist.domain.dto.UserResponse;
import com.alnicode.todolist.domain.service.IUserService;
import com.alnicode.todolist.persistence.mapper.IUserMapper;
import com.alnicode.todolist.persistence.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository repository;

    @Autowired
    private IUserMapper mapper;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserResponse register(AuthenticationRequest request) {
        final var entity = mapper.toEntity(request);
        entity.setPassword(encoder.encode(request.getPassword()));

        return mapper.toResponse(repository.save(entity));
    }
}
