package com.clovis.todo.controller.api;

import com.clovis.todo.dto.TaskDto;
import com.clovis.todo.models.TaskStatus;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "Task Management", description = "CRUD operations for managing tasks")
@RequestMapping("/api/tasks")
public interface TaskApi {

    @PostMapping(value = "/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
            @Operation(
            summary = "Créer une tâche",
            description = "Cette méthode permet d'enregistrer une tâche",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Tâche créé",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
                    @ApiResponse(responseCode = "400", description = "L'objet article n'est pas valide"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    ResponseEntity<TaskDto> createTask(@RequestBody TaskDto dto);
//    TaskDto createTask(@RequestBody TaskDto dto);



    @GetMapping(value = "/id/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
            @Operation(
            summary = "Rechercher une tache par ID",
            description = "Cette méthode permet de rechercher une tache par son ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "La tache a été trouvé dans la BDD",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
                    @ApiResponse(responseCode = "404", description = "Aucune tache trouvé dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<TaskDto> findById(@PathVariable Long id);
//    TaskDto findById(@PathVariable("id") TaskDto id);



    @GetMapping(value = "/status/{status}",
            produces = MediaType.APPLICATION_JSON_VALUE)
            @Operation(
            summary = "Rechercher une tache par STATU",
            description = "Cette méthode permet de rechercher une tache par son STATU",
            responses = {
                    @ApiResponse(responseCode = "200", description = "La tache a été trouvé dans la BDD",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
                    @ApiResponse(responseCode = "404", description = "Aucune tache trouvé dans la BDD avec l'ID fourni")
            }
    )
    ResponseEntity<List<TaskDto>> findByStatus(@PathVariable TaskStatus status);
//    TaskDto findByStatus(@PathVariable("id") TaskStatus status);



    @GetMapping(value = "/all",
            produces = MediaType.APPLICATION_JSON_VALUE)
            @Operation(
            summary = "Lister toutes les taches",
            description = "Cette méthode permet de renvoyer la liste des taches de la BDD",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Liste des taches ou liste vide",
                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = TaskDto.class))))
            }
    )
    ResponseEntity<List<TaskDto>> findAll();
//    List<TaskDto> findAll();



    @PutMapping(value = "/update/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
            @Operation(
            summary = "Modifier une tache",
            description = "Cette méthode permet d'enregistrer ou modifier un article",
            responses = {
                    @ApiResponse(responseCode = "200", description = "L'objet article créé / modifié",
                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
                    @ApiResponse(responseCode = "400", description = "La tache n'est pas valide"),
                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
            }
    )
    ResponseEntity<TaskDto> update(@PathVariable Long id, @RequestBody TaskDto dto);
//    TaskDto update(@RequestBody TaskDto dto);




    @DeleteMapping(value = "/delete/{id}")
            @Operation(
            summary = "Supprimer une tache",
            description = "Cette méthode permet de supprimer une tache par son ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "La tache a été supprimé")
            }
    )
    ResponseEntity<Void> delete(@PathVariable Long id);
//    void delete(Integer id);
}












//package com.clovis.todo.controller.api;
//
//import com.clovis.todo.dto.TaskDto;
//import com.clovis.todo.models.TaskStatus;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.ArraySchema;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@Tag(name = "Task Management", description = "CRUD operations for managing tasks in the To-Do List application")
//@RequestMapping("/api/tasks")
//public interface TaskApi {
//
//    @PostMapping(value = "/create",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Operation(
//            summary = "Créer une tâche",
//            description = "Cette méthode permet d'enregistrer une tâche",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "Tâche créé",
//                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
//                    @ApiResponse(responseCode = "400", description = "L'objet article n'est pas valide"),
//                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
//            }
//    )
//        ResponseEntity<TaskDto> createTask(@RequestBody TaskDto dto);
////    TaskDto createTask(@RequestBody TaskDto dto);
//
//
//
//    @GetMapping(value = "/{id}",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Operation(
//            summary = "Rechercher une tache par ID",
//            description = "Cette méthode permet de rechercher une tache par son ID",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "La tache a été trouvé dans la BDD",
//                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
//                    @ApiResponse(responseCode = "404", description = "Aucune tache trouvé dans la BDD avec l'ID fourni")
//            }
//    )
//        ResponseEntity<TaskDto> findById(@PathVariable Long id);
////    TaskDto findById(@PathVariable("id") TaskDto id);
//
//
//
//    @GetMapping(value = "/status/{status}",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Operation(
//            summary = "Rechercher une tache par STATU",
//            description = "Cette méthode permet de rechercher une tache par son STATU",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "La tache a été trouvé dans la BDD",
//                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
//                    @ApiResponse(responseCode = "404", description = "Aucune tache trouvé dans la BDD avec l'ID fourni")
//            }
//    )
//    TaskDto findByStatus(@PathVariable TaskStatus status);
////    TaskDto findById(@PathVariable("id") TaskDto id);
//
//
//
//    @GetMapping(value = "/all",
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Operation(
//            summary = "Lister toutes les taches",
//            description = "Cette méthode permet de renvoyer la liste des taches de la BDD",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "Liste des taches ou liste vide",
//                            content = @Content(array = @ArraySchema(schema = @Schema(implementation = TaskDto.class))))
//            }
//    )
//        ResponseEntity<List<TaskDto>> findAll();
////    List<TaskDto> findAll();
//
//
//
//    @PutMapping(value = "/update/{id}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    @Operation(
//            summary = "Modifier une tache",
//            description = "Cette méthode permet d'enregistrer ou modifier un article",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "L'objet article créé / modifié",
//                            content = @Content(schema = @Schema(implementation = TaskDto.class))),
//                    @ApiResponse(responseCode = "400", description = "La tache n'est pas valide"),
//                    @ApiResponse(responseCode = "500", description = "Erreur interne du serveur")
//            }
//    )
//        ResponseEntity<TaskDto> update(@RequestBody TaskDto dto);
////    TaskDto update(@RequestBody TaskDto dto);
//
//
//
//    @DeleteMapping(value = "/delete/{id}")
//    @Operation(
//            summary = "Supprimer une tache",
//            description = "Cette méthode permet de supprimer une tache par son ID",
//            responses = {
//                    @ApiResponse(responseCode = "200", description = "La tache a été supprimé")
//            }
//    )
//        ResponseEntity delete(@PathVariable("id") Long id);
////    void delete(Integer id);
//}
