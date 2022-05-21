package com.alnicode.todolist.persistence.mapper;

import com.alnicode.todolist.domain.dto.AuthenticationRequest;
import com.alnicode.todolist.domain.dto.UserResponse;
import com.alnicode.todolist.persistence.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserResponse toResponse(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "roles", ignore = true)
    User toEntity(AuthenticationRequest request);
}
