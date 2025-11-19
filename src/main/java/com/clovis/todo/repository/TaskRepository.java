package com.clovis.todo.repository;

import com.clovis.todo.models.Task;
import com.clovis.todo.models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByStatus(TaskStatus status);
}











//package com.clovis.todo.repository;
//
//import com.clovis.todo.models.Task;
//import com.clovis.todo.models.TaskStatus;
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.List;
//
//public interface TaskRepository extends JpaRepository<Task, Long> {
//    List<Task> findByStatus(TaskStatus status);
//}
