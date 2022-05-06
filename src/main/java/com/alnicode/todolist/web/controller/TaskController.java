package com.alnicode.todolist.web.controller;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.alnicode.todolist.domain.dto.TaskRequest;
import com.alnicode.todolist.domain.dto.TaskResponse;
import com.alnicode.todolist.domain.service.ICrudService;
import com.alnicode.todolist.domain.service.ITaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@Validated
public class TaskController extends CrudController<TaskRequest, TaskResponse> {
    @Autowired
    private ITaskService service;

    @Override
    protected ICrudService<TaskRequest, TaskResponse> service() {
        return this.service;
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<TaskResponse>> getByStatus(@NotNull @PathVariable("status") boolean status) {
        return ResponseEntity.of(this.service.getByStatus(status));
    }
    
    @PostMapping("/{id}/tag/{tagId}")
    public ResponseEntity<TaskResponse> addTag(@NotNull @Min(1L) @PathVariable("id") long taskId,
            @NotNull @Min(1L) @PathVariable("tagId") long tagId) {
        return ResponseEntity.of(this.service.addTag(taskId, tagId));
    }

    @DeleteMapping("/{id}/tag/{tagId}")
    public ResponseEntity<TaskResponse> removeTag(@NotNull @Min(1L) @PathVariable("id") long taskId,
            @NotNull @Min(1L) @PathVariable("tagId") long tagId) {
        return ResponseEntity.of(this.service.removeTag(taskId, tagId));
    }
}
