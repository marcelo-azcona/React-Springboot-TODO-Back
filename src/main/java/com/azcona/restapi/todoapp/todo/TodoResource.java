package com.azcona.restapi.todoapp.todo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {

	private TodoService todoService;

	public TodoResource(TodoService aTodoService) {
		super();
		this.todoService = aTodoService;
	}

	@GetMapping("/users/{username}/todos")
	private List<Todo> retrieveTodos(@PathVariable String username) {
		return todoService.findByUsername(username);
	}
}
