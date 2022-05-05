package com.alnicode.todolist.domain.service.impl;

import java.util.List;
import java.util.Optional;

import com.alnicode.todolist.domain.dto.TagRequest;
import com.alnicode.todolist.domain.dto.TagResponse;
import com.alnicode.todolist.domain.service.ITagService;
import com.alnicode.todolist.persistence.entity.Tag;
import com.alnicode.todolist.persistence.mapper.ITagMapper;
import com.alnicode.todolist.persistence.repository.ITagRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TagServiceImpl extends DeleteService<Tag> implements ITagService {
    @Autowired
    private ITagRepository repository;

    @Autowired
    private ITagMapper mapper;

    @Override
    @Transactional
    public TagResponse save(TagRequest request) {
        return this.mapper.toResponse(this.repository.save(this.mapper.toEntity(request)));
    }

    @Override
    @Transactional(readOnly = true)
    public List<TagResponse> getAll() {
        return this.mapper.toResponses(this.repository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<TagResponse> get(long id) {
        return this.repository.findById(id).map(mapper::toResponse);
    }

    @Override
    @Transactional
    public Optional<TagResponse> update(long id, TagRequest request) {
        if (!this.repository.existsById(id)) {
            return Optional.empty();
        }

        var entity = this.mapper.toEntity(request);
        entity.setId(id);

        return Optional.of(this.mapper.toResponse(this.repository.save(entity)));
    }

    @Override
    protected CrudRepository<Tag, Long> repository() {
        return this.repository;
    }
    
}
