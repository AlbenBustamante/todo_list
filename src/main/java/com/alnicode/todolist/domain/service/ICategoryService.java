package com.alnicode.todolist.domain.service;

import java.util.Optional;

import com.alnicode.todolist.domain.dto.CategoryRequest;
import com.alnicode.todolist.domain.dto.CategoryResponse;

public interface ICategoryService extends ICrudService<CategoryRequest, CategoryResponse> {
    Optional<CategoryResponse> getByTodoList(long todoListId);
}
