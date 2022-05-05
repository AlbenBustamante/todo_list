package com.alnicode.todolist.persistence.repository;

import java.util.List;
import java.util.Optional;

import com.alnicode.todolist.persistence.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {
    Optional<List<Task>> findByFinished(boolean finished);
    Optional<List<Task>> findByTasksId(long taskId);
}
