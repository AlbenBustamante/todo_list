package com.alnicode.todolist.domain.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class TodoListRequest {
    @NotBlank
    private String name;

    @NotNull
    @Min(1L)
    private long categoryId;
}
