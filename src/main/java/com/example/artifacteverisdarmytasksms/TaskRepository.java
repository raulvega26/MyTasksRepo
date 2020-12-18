package com.example.artifacteverisdarmytasksms;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	void save(Optional<Task> taskToUpdate);
}
