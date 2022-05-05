package com.alnicode.todolist.domain.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class TagRequest {
    @NotBlank
    private String name;
}
