package com.alnicode.todolist.web.controller;

import com.alnicode.todolist.domain.dto.CategoryRequest;
import com.alnicode.todolist.domain.dto.CategoryResponse;
import com.alnicode.todolist.domain.service.ICategoryService;
import com.alnicode.todolist.domain.service.ICrudService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController extends CrudController<CategoryRequest, CategoryResponse> {
    @Autowired
    private ICategoryService service;

    @Override
    protected ICrudService<CategoryRequest, CategoryResponse> service() {
        return this.service;
    }
    
}
