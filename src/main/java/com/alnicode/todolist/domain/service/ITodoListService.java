package com.alnicode.todolist.domain.service;

import java.util.List;
import java.util.Optional;

import com.alnicode.todolist.domain.dto.TodoListRequest;
import com.alnicode.todolist.domain.dto.TodoListResponse;

public interface ITodoListService extends ICrudService<TodoListRequest, TodoListResponse> {
    Optional<List<TodoListResponse>> getByCategory(long categoryId);
}
