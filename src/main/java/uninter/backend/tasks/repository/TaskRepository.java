package uninter.backend.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uninter.backend.tasks.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
