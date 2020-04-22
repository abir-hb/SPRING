package com.example.demo.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Task;
import com.example.demo.repository.TaskRepositrory;

@RestController
public class TestRestController {
	@Autowired
	private TaskRepositrory taskRepositrory;

	@GetMapping("/tasks")
	public List<Task> listTasks() {
		return taskRepositrory.findAll();
	}

	@PostMapping("/tasks")
	public Task save(@RequestBody Task t) {
		return taskRepositrory.save(t);
	}
}
