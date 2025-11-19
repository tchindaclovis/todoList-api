package com.clovis.todo.controller;

import com.clovis.todo.controller.api.TaskApi;
import com.clovis.todo.dto.TaskDto;
import com.clovis.todo.models.TaskStatus;
import com.clovis.todo.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class TaskController implements TaskApi {

    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @Override
    public ResponseEntity<TaskDto> createTask(TaskDto dto) {
        return ResponseEntity.ok(taskService.createTask(dto));
    }

    @Override
    public ResponseEntity<TaskDto> findById(Long id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @Override
    public ResponseEntity<List<TaskDto>> findByStatus(TaskStatus status) {
        return ResponseEntity.ok(taskService.findByStatus(status));
    }

    @Override
    public ResponseEntity<List<TaskDto>> findAll() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @Override
    public ResponseEntity<TaskDto> update(Long id, TaskDto dto) {
        return ResponseEntity.ok(taskService.update(id, dto));
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }
}






















//package com.clovis.todo.controller;
//
//import com.clovis.todo.controller.api.TaskApi;
//import com.clovis.todo.dto.TaskDto;
//import com.clovis.todo.models.TaskStatus;
//import com.clovis.todo.services.TaskService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//public class TaskController implements TaskApi {
//    private TaskService taskService;
//
//    @Autowired  //Constructor injection sur le constructeur
//    public TaskController(TaskService taskService){
//        this.taskService = taskService;
//    }
//
//
//
//    @Override
//    public ResponseEntity<TaskDto> createTask(TaskDto dto) {
//        return ResponseEntity.ok(taskService.createTask(dto));
//    }
//
//    @Override
//    public ResponseEntity<TaskDto> findById(Long id) {
//        return ResponseEntity.ok(taskService.findById(id));
//    }
//
//    @Override
//    public TaskDto findByStatus(TaskStatus status) {
//        return taskService.findByStatus(status);
//    }
////    @Override
////    public TaskDto findById(Long id) {
////        return taskService.findById(id);
////    }
//
//
//
//    @Override
//    public ResponseEntity<List<TaskDto>> findAll() {
//        return ResponseEntity.ok(taskService.findAll());
//    }
//
//    @Override
//    public ResponseEntity<TaskDto> update(TaskDto dto) {
//        return null;
//    }
////    @Override
////    public List<TaskDto> findAll() {
////        return taskService.findAll();
////    }
//
//
//
//
//    @Override
//    public ResponseEntity delete(Long id) {
//        taskService.delete(id);
//        return ResponseEntity.ok().build();
//    }
//
//}




/**
 * Retrieve all tasks
 *
 * @param status the status to filter tasks by. If null, all tasks are retrieved.
 * @return the list of tasks
 */

//    @GetMapping
//    public ResponseEntity<List<Task>> getTasks(
//            @Parameter(
//                    description = "Task status to filter tasks by (TODO, IN_PROGRESS, DONE)",
//                    required = false)
//            @RequestParam(value = "status", required = false) TaskStatus status) {
//        if(status != null) {
//            return ResponseEntity.ok(taskService.getTasksByStatus(status));
//        } else {
//            return ResponseEntity.ok(taskService.getAllTasks());
//        }
//    }

/**
 * Update an existing task
 *
 * @param id the ID of the task to update
 * @param task the updated task object
 * @return the updated task
 */

//    @Operation(
//            summary = "Update an existing task",
//            description = "Updates an existing task based on the provided ID. You may update the title, description, or status."
//    )
//    @PutMapping("/{id}")
//    public ResponseEntity<Task> updateTask(
//            @Parameter(description = "ID of the task to update",
//                    required = true)
//            @PathVariable Long id,
//            @Parameter(description = "Updated task object with new details", required = true)
//            @RequestBody Task task) {
//        Task updatedTask = taskService.updateTask(id, task);
//        if(updatedTask ==  null) {
//            return ResponseEntity.notFound().build();
//        }
//        return ResponseEntity.ok(updatedTask);
//    }

/**
 * Delete a task
 *
 * @param id the ID of the task to be deleted
 * @return a response with a 204 status code indicating deletion success
 */

//    @Operation(
//            summary = "Delete a task",
//            description = "Deletes the task specified by the provided ID."
//    )
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteTask(
//            @Parameter(description = "ID of the task to be deleted", required = true)
//            @PathVariable Long id) {
//        taskService.deleteTask(id);
//        return ResponseEntity.ok().build();
//    }
