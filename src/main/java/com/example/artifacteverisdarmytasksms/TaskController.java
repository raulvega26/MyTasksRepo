package com.example.artifacteverisdarmytasksms;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	TaskService service;
	
	@RequestMapping(value = "/tasks", method = RequestMethod.GET, produces = "application/json")
	public List<Task> getAllTasks() {
		log.info("Getting tasks details from the database");
		return service.getAll();
	}
	
	@RequestMapping(value = "/tasks/{id}" , method = RequestMethod.GET, produces = "application/json")
	public Optional<Task> getTaskById(@PathVariable Long id) {
		return service.findTaskById(id);
	}
	
	@RequestMapping(value = "/tasks/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")		
	@ResponseStatus(HttpStatus.CREATED)
	public Task addTask(@RequestBody Task task) {
		return service.saveTask(task);
	}
	
	@RequestMapping(value = "/tasks/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")		
	public String deleteTask(@PathVariable Long id) {			
		return service.deleteTask(id);
	}
	
	@RequestMapping(value = "/tasks/update", method = RequestMethod.PATCH, produces = "application/json")		
	public String updateTask(@RequestBody Task task) {			
		return service.updateTask(task);		
	}
	
}
