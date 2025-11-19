package com.clovis.todo.dto;

import com.clovis.todo.models.Task;
import com.clovis.todo.models.TaskStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class TaskDto {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    private String title;

    private String designation;

    private String description;

    private TaskStatus status;


    //permet de faire un mapping de CategoryDto vers Category
    public static TaskDto fromEntity (Task task){
        if(task == null){
            return null;
        }
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .designation(task.getDesignation())
                .description(task.getDescription())
                .status(task.getStatus())
                .build();
    }

    public static Task toEntity (TaskDto taskDto){
        if(taskDto == null){
            return null;
        }
        Task task = new Task();
        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDesignation(taskDto.getDesignation());
        task.setDescription(taskDto.getDescription());
        task.setStatus(taskDto.getStatus());
        return task;
    }
}
