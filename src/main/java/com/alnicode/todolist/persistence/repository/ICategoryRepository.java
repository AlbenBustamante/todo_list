package com.alnicode.todolist.persistence.repository;

import java.util.Optional;

import com.alnicode.todolist.persistence.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findByTodoListsId(long todoListId);
}
