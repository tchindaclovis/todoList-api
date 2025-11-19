package com.clovis.todo.services;

import com.clovis.todo.dto.TaskDto;
import com.clovis.todo.models.TaskStatus;
import java.util.List;

public interface TaskService {
    TaskDto createTask(TaskDto dto);
    TaskDto findById(Long id);
    List<TaskDto> findByStatus(TaskStatus status);
    TaskDto update(Long id, TaskDto dto);
    List<TaskDto> findAll();
    void delete(Long id);
}























//package com.clovis.todo.services;
//
//import com.clovis.todo.dto.TaskDto;
//import com.clovis.todo.models.TaskStatus;
//import java.util.List;
//
//public interface TaskService {
//    TaskDto createTask(TaskDto dto);
//    TaskDto findById(Long id);
//    TaskDto findByStatus(TaskStatus status);
//    TaskDto update(TaskDto dto);
//    List<TaskDto> findAll();
//
//    void delete(Long id);
//}





///**
// * Service class for Task entities. Provides business logic
// * for Task related operations.
// */

//    /**
//     * Constructor.
//     *
//     * @param taskRepository The TaskRepository instance.
//     */
//
//
//
//    /**
//     * Retrieves a list of all tasks.
//     *
//     * @return A list of all tasks.
//     */
//    public List<Task> getAllTasks() {
//        return taskRepository.findAll();
//    }
//
//    /**
//     * Creates a new task.
//     *
//     * @param task The task to create.
//     * @return The created task.
//     */
//    public Task createTask(Task task) {
//        task.setId(null);
//        return taskRepository.save(task);
//    }
//
//    /**
//     * Retrieves a list of tasks with a given status.
//     *
//     * @param status The task status.
//     * @return A list of tasks with the given status.
//     */
//    public List<Task> getTasksByStatus(TaskStatus status) {
//        return taskRepository.findByStatus(status);
//    }
//
//    /**
//     * Updates a task.
//     *
//     * @param id         The ID of the task to update.
//     * @param updatedTask The updated task.
//     * @return The updated task or null if the task does not exist.
//     */
//    public Task updateTask(Long id, Task updatedTask) {
//        Optional<Task> optionalTask = taskRepository.findById(id);
//        if (optionalTask.isPresent()) {
//            Task existingtask = optionalTask.get();
//            existingtask.setTitle(updatedTask.getTitle());
//            existingtask.setDescription(updatedTask.getDescription());
//            existingtask.setStatus(updatedTask.getStatus());
//            return taskRepository.save(existingtask);
//        }
//        return null;
//    }
//
//    /**
//     * Deletes a task.
//     *
//     * @param id The ID of the task to delete.
//     */
//    public void deleteTask(Long id) {
//        taskRepository.deleteById(id);
//    }
