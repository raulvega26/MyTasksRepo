package com.example.artifacteverisdarmytasksms;

import javax.persistence.*;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column
	private String description;

	@Column
	@JsonProperty("statusName")
	private String status_name;
	
	public Task() {}
	
	public Task(String description, String status_name) {

		this.description = description;
		this.status_name = status_name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus_name() {
		return status_name;
	}

	public void setStatus_name(String status_name) {
		this.status_name = status_name;
	}
	
	public interface TaskRepository extends JpaRepository<Task, Long> {
		Task findByDescription(String taskDescription);
	}
}
