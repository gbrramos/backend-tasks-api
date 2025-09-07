package uninter.backend.tasks_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uninter.backend.tasks_api.entity.Task;
import uninter.backend.tasks_api.repository.TaskRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    private final TaskRepository taskRepository;

    public TasksController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public ResponseEntity<String> listTasks() {
        return ResponseEntity.ok("Hello");
    }

    @PostMapping
    public ResponseEntity<String> saveTasks(Task task) {
        this.taskRepository.save(task);

        return ResponseEntity.ok("Ok");
    }

    
}
