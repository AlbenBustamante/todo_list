package com.alnicode.todolist.domain.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class TaskResponse {
    private long id;
    private String description;
    private String assignedDate;
    private boolean status;
    private Set<TagResponse> tags = new HashSet<>();
}
