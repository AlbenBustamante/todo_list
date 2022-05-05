package com.alnicode.todolist.persistence.mapper;

import java.util.List;

import com.alnicode.todolist.domain.dto.TaskRequest;
import com.alnicode.todolist.domain.dto.TaskResponse;
import com.alnicode.todolist.persistence.entity.Task;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = { ITagMapper.class })
public interface ITaskMapper {
    TaskResponse toResponse(Task entity);
    List<TaskResponse> toResponses(List<Task> entities);

    Task toEntity(TaskRequest request);
}
