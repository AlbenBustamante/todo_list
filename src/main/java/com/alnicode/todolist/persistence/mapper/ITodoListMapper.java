package com.alnicode.todolist.persistence.mapper;

import java.util.List;

import com.alnicode.todolist.domain.dto.TodoListRequest;
import com.alnicode.todolist.domain.dto.TodoListResponse;
import com.alnicode.todolist.persistence.entity.TodoList;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ITaskMapper.class })
public interface ITodoListMapper {
    TodoListResponse toResponse(TodoList entity);
    List<TodoListResponse> toResponses(List<TodoList> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "category", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    TodoList toEntity(TodoListRequest request);
}
