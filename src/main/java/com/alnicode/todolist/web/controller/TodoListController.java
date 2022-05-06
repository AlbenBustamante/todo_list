package com.alnicode.todolist.web.controller;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.alnicode.todolist.domain.dto.CategoryResponse;
import com.alnicode.todolist.domain.dto.TaskResponse;
import com.alnicode.todolist.domain.dto.TodoListRequest;
import com.alnicode.todolist.domain.dto.TodoListResponse;
import com.alnicode.todolist.domain.service.ICategoryService;
import com.alnicode.todolist.domain.service.ICrudService;
import com.alnicode.todolist.domain.service.ITaskService;
import com.alnicode.todolist.domain.service.ITodoListService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todolists")
@Validated
public class TodoListController extends CrudController<TodoListRequest, TodoListResponse> {
    @Autowired
    private ITodoListService service;

    @Autowired
    private ICategoryService categoryService;

    @Autowired
    private ITaskService taskService;

    @Override
    protected ICrudService<TodoListRequest, TodoListResponse> service() {
        return this.service;
    }

    @GetMapping("/{id}/category")
    public ResponseEntity<CategoryResponse> getCategory(@NotNull @Min(1L) @PathVariable("id") long todoListId) {
        return ResponseEntity.of(this.categoryService.getByTodoList(todoListId));
    }

    @GetMapping("/{id}/tasks")
    public ResponseEntity<List<TaskResponse>> getTasks(@NotNull @Min(1L) @PathVariable("id") long todoListId) {
        return ResponseEntity.of(this.taskService.getByTodoList(todoListId));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<TodoListResponse>> getAllByCategory(@NotNull @Min(1L) @PathVariable("id") long categoryId) {
        return ResponseEntity.of(this.service.getByCategory(categoryId));
    }
    
}
