package br.com.felipemeireles.todolist.controller;

import br.com.felipemeireles.todolist.repository.TaskRepository;
import br.com.felipemeireles.todolist.model.TaskModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/")
    public TaskModel criar(@RequestBody TaskModel taskModel){
        var task = taskRepository.save(taskModel);
        return task;
    }
}
