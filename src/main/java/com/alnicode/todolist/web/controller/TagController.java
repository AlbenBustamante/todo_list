package com.alnicode.todolist.web.controller;

import com.alnicode.todolist.domain.dto.TagRequest;
import com.alnicode.todolist.domain.dto.TagResponse;
import com.alnicode.todolist.domain.service.ICrudService;
import com.alnicode.todolist.domain.service.ITagService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagController extends CrudController<TagRequest, TagResponse> {
    @Autowired
    private ITagService service;

    @Override
    protected ICrudService<TagRequest, TagResponse> service() {
        return this.service;
    }
    
}
