package com.alnicode.todolist.domain.service;

import java.util.List;
import java.util.Optional;

import com.alnicode.todolist.domain.dto.TaskRequest;
import com.alnicode.todolist.domain.dto.TaskResponse;

public interface ITaskService extends ICrudService<TaskRequest, TaskResponse> {
    Optional<List<TaskResponse>> getByStatus(boolean status);
    Optional<List<TaskResponse>> getByTodoList(long todoListId);
    Optional<TaskResponse> addTag(long taskId, long tagId);
    boolean removeTag(long taskId, long tagId);
}
