package br.com.felipemeireles.todolist.controller;

import br.com.felipemeireles.todolist.repository.TaskRepository;
import br.com.felipemeireles.todolist.model.TaskModel;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/")
    public ResponseEntity criar(@RequestBody TaskModel taskModel, HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        taskModel.setIdUser((UUID) idUser);

        var currentDate = LocalDateTime.now();

        if (currentDate.isAfter(taskModel.getStartAt()) || currentDate.isAfter(taskModel.getEndAt())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A data de início / data de término. deve ser maior do que a data atual");
        }

        if (taskModel.getStartAt().isAfter(taskModel.getEndAt())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("A data de início deve ser menor do que a data de término");
        }

        var task = taskRepository.save(taskModel);
        return ResponseEntity.status(HttpStatus.OK).body(task);
    }

    @GetMapping("/")
    public Optional<TaskModel> list(HttpServletRequest request){
        var idUser = request.getAttribute("idUser");
        var tasks = taskRepository.findById((UUID) idUser);
        return tasks;
    }
}
