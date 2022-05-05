package com.alnicode.todolist.persistence.mapper;

import static com.alnicode.todolist.util.AppConstants.DATE_FORMAT;

import java.util.List;

import com.alnicode.todolist.domain.dto.TaskRequest;
import com.alnicode.todolist.domain.dto.TaskResponse;
import com.alnicode.todolist.persistence.entity.Task;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = { ITagMapper.class })
public interface ITaskMapper {
    @Mapping(target = "assignedDate", dateFormat = DATE_FORMAT)
    @Mapping(target = "status", source = "finished")
    TaskResponse toResponse(Task entity);
    List<TaskResponse> toResponses(List<Task> entities);

    @Mapping(target = "assignedDate", source = "date", dateFormat = DATE_FORMAT)
    @Mapping(target = "finished", source = "status")
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "todoList", ignore = true)
    @Mapping(target = "tags", ignore = true)
    Task toEntity(TaskRequest request);
}
