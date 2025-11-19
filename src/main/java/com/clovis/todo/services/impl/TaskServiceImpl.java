package com.clovis.todo.services.impl;

import com.clovis.todo.exception.ErrorCodes;
import com.clovis.todo.dto.TaskDto;
import com.clovis.todo.exception.InvalidEntityException;
import com.clovis.todo.models.Task;
import com.clovis.todo.models.TaskStatus;
import com.clovis.todo.repository.TaskRepository;
import com.clovis.todo.services.TaskService;
import com.clovis.todo.validator.TaskValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDto createTask(TaskDto dto) {
//        Task task = TaskDto.toEntity(dto);
        List<String> errors = TaskValidator.validate(dto);
        if(!errors.isEmpty()){
            log.error("Task is not valid{}", dto);
            throw new InvalidEntityException("La tache n'est pas valide", ErrorCodes.TASK_NOT_VALID, errors);
        }

        return TaskDto.fromEntity(taskRepository.save(TaskDto.toEntity(dto)));
    }



    @Override
    public TaskDto findById(Long id) {
        return taskRepository.findById(id)
                .map(TaskDto::fromEntity)
                .orElseThrow(() ->
                        new RuntimeException("Aucune tâche trouvée dans la BDD avec l'ID fourni"));
    }


//    @Override
//    public TaskDto findById(Long id) {
//        Task task = taskRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Aucune tache trouvée avec ID " + id));
//        return TaskDto.fromEntity(task);
//    }



//    @Override
//    public List<TaskDto>  findByStatus(TaskStatus status) {
//        return taskRepository.findByStatus(status)
//                .map(TaskDto::fromEntity)
//                .orElseThrow(() ->
//                        new RuntimeException("Aucune tâche trouvée avec le status " + status));
//    }

    @Override
    public List<TaskDto> findByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status)
                .stream()
                .map(TaskDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto update(Long id, TaskDto dto) {
        Task existing = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aucune tache trouvée avec ID " + id));

        existing.setTitle(dto.getTitle());
        existing.setDescription(dto.getDescription());
        existing.setStatus(dto.getStatus());

        return TaskDto.fromEntity(taskRepository.save(existing));
    }

    @Override
    public List<TaskDto> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(TaskDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new RuntimeException("Impossible de supprimer : Id " + id + " introuvable");
        }
        taskRepository.deleteById(id);
    }
}























//package com.clovis.todo.services.impl;
//
//import com.clovis.todo.dto.TaskDto;
//import com.clovis.todo.models.TaskStatus;
//import com.clovis.todo.repository.TaskRepository;
//import com.clovis.todo.services.TaskService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@Slf4j
////@RequiredArgsConstructor
//public class TaskServiceImpl implements TaskService {
//    private TaskRepository taskRepository;
//
//    @Autowired  //Constructor injection sur le constructeur
//    public TaskServiceImpl(TaskRepository taskRepository){
//        this.taskRepository = taskRepository;
//    }
//
//
//    @Override
//    public TaskDto createTask(TaskDto dto){
//        return TaskDto.fromEntity(
//                taskRepository.save(
//                        TaskDto.toEntity(dto)
//                )
//        );
//    }
//
//
//    @Override
//    public TaskDto findById(Long id) {
////        if(id == null){
////            log.error("Article ID is null");
////            return null;
////        }
////        Optional<Task> task = taskRepository.findById(id);
////        return Optional.of(TaskDto.fromEntity(task.get())).orElseThrow(() ->
////                new EntityNotFoundException(
////                        "Aucun article avec l'ID = " + id + "n'a ete trouve dans la BDD",
////                        ErrorCodes.ARTICLE_NOT_FOUND)
////        );
//        return null;
//    }
//
//    @Override
//    public TaskDto findByStatus(TaskStatus status) {
//        return null;
//    }
//
//    @Override
//    public TaskDto update(TaskDto dto) {
//        return null;
//    }
//
//
//    @Override
//    public List<TaskDto> findAll() {
//        return taskRepository.findAll().stream()
//                .map(TaskDto::fromEntity)
//                .collect(Collectors.toList());
//    }
//
//
//    @Override
//    public void delete(Long id) {
//
//    }
//
//}



//    public List<Task> getAllTasks() {
//        return taskRepository.findAll();
//    }

//    public Task createTask(Task task) {
//        task.setId(null);
//        return taskRepository.save(task);
//    }



// Article savedArticle = articleRepository.save(ArticleDto.toEntity(dto));
//return ArticleDto.fromEntity(savedArticle);



//    public List<Task> getTasksByStatus(TaskStatus status) {
//        return taskRepository.findByStatus(status);
//    }
//
//
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
