package com.alnicode.todolist.domain.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class CategoryRequest {
    @NotBlank
    private String name;
}
