package com.alnicode.todolist.domain.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TaskRequest {
    @NotBlank
    private String description;

    @NotBlank
    private String date;

    private boolean status;

    @NotNull
    @Min(1L)
    private long todoListId;
}
