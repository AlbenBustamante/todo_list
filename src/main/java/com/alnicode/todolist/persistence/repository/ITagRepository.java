package com.alnicode.todolist.persistence.repository;

import com.alnicode.todolist.persistence.entity.Tag;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITagRepository extends JpaRepository<Tag, Long> {
    
}
