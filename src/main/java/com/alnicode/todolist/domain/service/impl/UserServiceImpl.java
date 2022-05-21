package com.alnicode.todolist.domain.service.impl;

import com.alnicode.todolist.domain.dto.AuthenticationRequest;
import com.alnicode.todolist.domain.dto.UserResponse;
import com.alnicode.todolist.domain.service.IUserService;
import com.alnicode.todolist.persistence.entity.Role;
import com.alnicode.todolist.persistence.entity.User;
import com.alnicode.todolist.persistence.mapper.IUserMapper;
import com.alnicode.todolist.persistence.repository.IRoleRepository;
import com.alnicode.todolist.persistence.repository.IUserRepository;
import java.util.HashSet;
import java.util.Set;
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

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public UserResponse register(AuthenticationRequest request) {
        final var entity = mapper.toEntity(request);
        entity.setPassword(encoder.encode(request.getPassword()));
        setRoles(entity);

        return mapper.toResponse(repository.save(entity));
    }

    private void setRoles(User entity) {
        final var role = roleRepository.findByName("USER");
        final Set<Role> roles = new HashSet<>();

        if (role.isPresent()) {
            roles.add(role.get());
        } else {
            final var newRole = new Role();
            newRole.setName("USER");

            roles.add(newRole);
        }

        entity.setRoles(roles);
    }
}
