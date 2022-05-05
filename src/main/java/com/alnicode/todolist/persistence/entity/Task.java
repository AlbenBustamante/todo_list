package com.alnicode.todolist.persistence.entity;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "taks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @Size(min = 10, max = 300)
    private String description;

    @NotNull
    @Future
    @DateTimeFormat(iso = ISO.DATE)
    @Column(name = "assigned_date")
    private LocalDateTime assignedDate;

    @NotNull
    private Boolean finished;

    @NotNull
    @Min(1L)
    @Max(Long.MAX_VALUE)
    @Column(name = "todo_list_id")
    private Long todoListId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_list_id", insertable = false, updatable = false)
    private TodoList todoList;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
        name = "tasks_tags",
        joinColumns = @JoinColumn(name = "task_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags = Collections.emptySet();

    public void addTag(Tag tag) {
        this.tags.add(tag);
        tag.getTasks().add(this);
    }

    public void removeTag(Tag tag) {
        this.tags.remove(tag);
        tag.getTasks().remove(this);
    }
}
