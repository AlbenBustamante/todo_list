package com.alnicode.todolist.persistence.repository;

import com.alnicode.todolist.persistence.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {
    
}
