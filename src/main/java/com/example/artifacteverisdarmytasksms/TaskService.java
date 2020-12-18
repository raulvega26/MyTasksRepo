package com.example.artifacteverisdarmytasksms;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	@Autowired
	TaskRepository repository;
	
	public List<Task> getAll() {
		final List<Task> tasks = new ArrayList<>();
		repository.findAll().forEach(task -> tasks.add(task));
		return tasks;
	}
	
	public Optional<Task> findTaskById(Long id){
		Optional<Task> task = repository.findById(id);
		return task;
	}
	
	public Task saveTask(final Task task) {
		if (task != null) {
			return repository.save(task);
		}
		return new Task();
	}
	
	public String deleteTask(Long id) {
		if(repository.findById(id).isPresent()) {
			repository.deleteById(id);
			return "Task eliminated";
		}
		return "Error! task does not exist!";
	}
	
	public String updateTask(Task task) {
		Long num = task.getId();
		if(repository.findById(num).isPresent()) {
			Task taskToUpdate = new Task(task.getDescription(), task.getStatus_name());
			repository.save(taskToUpdate);
			return "Task modified";
		}
		return "Error modifying the task";
	}
}
