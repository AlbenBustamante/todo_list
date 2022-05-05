package com.alnicode.todolist.domain.service.impl;

import java.util.List;
import java.util.Optional;

import com.alnicode.todolist.domain.dto.TaskRequest;
import com.alnicode.todolist.domain.dto.TaskResponse;
import com.alnicode.todolist.domain.service.ITaskService;
import com.alnicode.todolist.persistence.entity.Task;
import com.alnicode.todolist.persistence.mapper.ITaskMapper;
import com.alnicode.todolist.persistence.repository.ITagRepository;
import com.alnicode.todolist.persistence.repository.ITaskRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TaskServiceImpl extends DeleteService<Task> implements ITaskService {
    @Autowired
    private ITaskRepository repository;

    @Autowired
    private ITaskMapper mapper;

    @Autowired
    private ITagRepository tagRepository;

    @Override
    @Transactional
    public TaskResponse save(TaskRequest request) {
        return this.mapper.toResponse(this.repository.save(this.mapper.toEntity(request)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TaskResponse> getAll() {
        return this.mapper.toResponses(this.repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TaskResponse> get(long id) {
        return this.repository.findById(id).map(mapper::toResponse);
    }

    @Override
    @Transactional
    public Optional<TaskResponse> update(long id, TaskRequest request) {
        if (!this.repository.existsById(id)) {
            return Optional.empty();
        }

        var entity = this.mapper.toEntity(request);
        entity.setId(id);

        return Optional.of(this.mapper.toResponse(this.repository.save(entity)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TaskResponse>> getByStatus(boolean status) {
        return this.repository.findByFinished(status).map(mapper::toResponses);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TaskResponse>> getByTodoList(long todoListId) {
        return this.repository.findByTodoListId(todoListId).map(mapper::toResponses);
    }

    @Override
    @Transactional
    public Optional<TaskResponse> addTag(long taskId, long tagId) {
        var task = this.repository.findById(taskId);
        var tag = this.tagRepository.findById(tagId);

        if (!(task.isPresent() && tag.isPresent())) {
            return Optional.empty();
        }

        task.get().addTag(tag.get());

        return Optional.of(this.mapper.toResponse(this.repository.save(task.get())));
    }

    @Override
    public Optional<TaskResponse> removeTag(long taskId, long tagId) {
        var task = this.repository.findById(taskId);
        var tag = this.tagRepository.findById(tagId);

        if (!(task.isPresent() && tag.isPresent())) {
            return Optional.empty();
        }

        task.get().removeTag(tag.get());

        return Optional.of(this.mapper.toResponse(this.repository.save(task.get())));
    }

    @Override
    protected CrudRepository<Task, Long> repository() {
        return this.repository;
    }
    
}
