package com.alnicode.todolist.domain.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TaskRequest {
    @NotBlank
    private String description;

    @NotBlank
    private String date;

    private boolean status;
}
