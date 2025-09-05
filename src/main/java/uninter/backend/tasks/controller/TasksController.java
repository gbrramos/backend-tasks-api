package uninter.backend.tasks.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uninter.backend.tasks.entity.Task;
import uninter.backend.tasks.repository.TaskRepository;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/tasks")
public class TasksController {
    private final TaskRepository taskRepository;

    public TasksController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping
    public ResponseEntity<List<Task>> listTasks() {
        List<Task> lstTasks = this.taskRepository.findAll();
        return ResponseEntity.ok(lstTasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Task task = this.taskRepository.findById(id).orElse(null);
        
        if (Objects.isNull(task)) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(task);
    }

    @PostMapping
    public ResponseEntity<String> saveTasks(@RequestBody Task task) {
        this.taskRepository.save(task);

        return ResponseEntity.status(HttpStatus.CREATED).body("Tarefa criada com sucesso!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTasks(@PathVariable Long id, @RequestBody Task payload) {
        Task task = this.taskRepository.findById(id).orElse(null);

        if (Objects.isNull(task)) {
            return ResponseEntity.notFound().build();
        }

        task.setData(payload.getData());
        task.setName(payload.getName());
        task.setResponsavel(payload.getResponsavel());

        this.taskRepository.save(task);

        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        Task task = this.taskRepository.findById(id).orElse(null);
        if (Objects.isNull(task)) {
            return ResponseEntity.notFound().build();
        }
        this.taskRepository.deleteById(id);
        return ResponseEntity.ok("Tarefa deletada com sucesso!");
    }
}
    