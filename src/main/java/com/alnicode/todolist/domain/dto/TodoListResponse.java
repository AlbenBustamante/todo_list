package com.alnicode.todolist.domain.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class TodoListResponse {
    private long id;
    private String name;
    private Set<TaskResponse> tasks = new HashSet<>();
}
