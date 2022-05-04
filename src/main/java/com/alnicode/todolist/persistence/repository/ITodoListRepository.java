package com.alnicode.todolist.persistence.repository;

import com.alnicode.todolist.persistence.entity.TodoList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITodoListRepository extends JpaRepository<TodoList, Long> {
    
}
