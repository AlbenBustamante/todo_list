package com.alnicode.todolist.persistence.mapper;

import java.util.List;

import com.alnicode.todolist.domain.dto.TagRequest;
import com.alnicode.todolist.domain.dto.TagResponse;
import com.alnicode.todolist.persistence.entity.Tag;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ITagMapper {
    TagResponse toResponse(Tag entity);
    List<TagResponse> toResponses(List<Tag> entities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "tasks", ignore = true)
    Tag toEntity(TagRequest request);
}
