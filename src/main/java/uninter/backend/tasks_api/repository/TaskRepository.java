package uninter.backend.tasks_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uninter.backend.tasks_api.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
    
}
