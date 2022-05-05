package com.alnicode.todolist.domain.service.impl;

import java.util.List;
import java.util.Optional;

import com.alnicode.todolist.domain.dto.TodoListRequest;
import com.alnicode.todolist.domain.dto.TodoListResponse;
import com.alnicode.todolist.domain.service.ITodoListService;
import com.alnicode.todolist.persistence.entity.TodoList;
import com.alnicode.todolist.persistence.mapper.ITodoListMapper;
import com.alnicode.todolist.persistence.repository.ITodoListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TodoListServiceImpl extends DeleteService<TodoList> implements ITodoListService {
    @Autowired
    private ITodoListMapper mapper;

    @Autowired
    private ITodoListRepository repository;

    @Override
    @Transactional
    public TodoListResponse save(TodoListRequest request) {
        return this.mapper.toResponse(this.repository.save(this.mapper.toEntity(request)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TodoListResponse> getAll() {
        return this.mapper.toResponses(this.repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TodoListResponse> get(long id) {
        return this.repository.findById(id).map(mapper::toResponse);
    }

    @Override
    @Transactional
    public Optional<TodoListResponse> update(long id, TodoListRequest request) {
        if (!this.repository.existsById(id)) {
            return Optional.empty();
        }

        var entity = this.mapper.toEntity(request);
        entity.setId(id);

        return Optional.of(this.mapper.toResponse(this.repository.save(entity)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<List<TodoListResponse>> getByCategory(long categoryId) {
        return this.repository.findByCategoryId(categoryId).map(mapper::toResponses);
    }

    @Override
    protected CrudRepository<TodoList, Long> repository() {
        return this.repository;
    }
    
}
