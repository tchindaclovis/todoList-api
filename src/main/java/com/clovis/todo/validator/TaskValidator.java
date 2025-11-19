package com.clovis.todo.validator;

import com.clovis.todo.dto.TaskDto;
import org.springframework.util.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class TaskValidator {
    public static List<String> validate(TaskDto dto){
        List< String> errors = new ArrayList<>();
        if(dto == null){
            errors.add("Veuillez renseigner le titre de la tache");
            errors.add("Veuillez renseigner la description de la tache");
            errors.add("Veuillez renseigner le prix unitaire HT de l'article");
            errors.add("Veuillez renseigner le statu de la tache");
            return errors;
        }

        if(!StringUtils.hasLength(dto.getTitle())){
            errors.add("Veuillez renseigner le code de l'article");
        }

        if(!StringUtils.hasLength(dto.getDescription())){
            errors.add("Veuillez renseigner la désignation de l'article");
        }

//        if(dto.getPrixUnitaireHt() == null){
//            errors.add("Veuillez renseigner le prix unitaire HT de l'article");
//        }

        if (!StringUtils.hasLength(dto.getStatus().toString())) {
            errors.add("Veuillez renseigner l'etat de la commande");
        }

        return errors;
    }
}
