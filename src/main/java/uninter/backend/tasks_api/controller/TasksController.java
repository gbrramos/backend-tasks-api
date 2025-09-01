package uninter.backend.tasks_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @GetMapping
    public ResponseEntity<String> listTasks() {
        return ResponseEntity.ok("Hello");
    }
    
}
