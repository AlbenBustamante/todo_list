package com.alnicode.todolist.domain.service.impl;

import java.util.List;
import java.util.Optional;

import com.alnicode.todolist.domain.dto.CategoryRequest;
import com.alnicode.todolist.domain.dto.CategoryResponse;
import com.alnicode.todolist.domain.service.ICategoryService;
import com.alnicode.todolist.persistence.entity.Category;
import com.alnicode.todolist.persistence.mapper.ICategoryMapper;
import com.alnicode.todolist.persistence.repository.ICategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl extends DeleteService<Category> implements ICategoryService {
    @Autowired
    private ICategoryRepository repository;

    @Autowired
    private ICategoryMapper mapper;

    @Override
    @Transactional
    public CategoryResponse save(CategoryRequest request) {
        return this.mapper.toResponse(this.repository.save(this.mapper.toEntity(request)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoryResponse> getAll() {
        return this.mapper.toResponses(this.repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CategoryResponse> get(long id) {
        return this.repository.findById(id).map(mapper::toResponse);
    }

    @Override
    @Transactional
    public Optional<CategoryResponse> update(long id, CategoryRequest request) {
        if (!this.repository.existsById(id)) {
            return Optional.empty();
        }

        var entity = this.mapper.toEntity(request);
        entity.setId(id);

        return Optional.of(this.mapper.toResponse(this.repository.save(entity)));
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CategoryResponse> getByTodoList(long todoListId) {
        return this.repository.findByTodoListsId(todoListId).map(mapper::toResponse);
    }

    @Override
    protected CrudRepository<Category, Long> repository() {
        return this.repository;
    }
    
}
