package com.alnicode.todolist.persistence.mapper;

import java.util.List;

import com.alnicode.todolist.domain.dto.CategoryRequest;
import com.alnicode.todolist.domain.dto.CategoryResponse;
import com.alnicode.todolist.persistence.entity.Category;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {
    CategoryResponse toResponse(Category entity);
    List<CategoryResponse> toResponses(List<Category> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "todoLists", ignore = true)
    Category toEntity(CategoryRequest request);
}
