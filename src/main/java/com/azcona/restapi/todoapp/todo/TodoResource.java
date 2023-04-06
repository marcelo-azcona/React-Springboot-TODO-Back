package com.azcona.restapi.todoapp.todo;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/users/{username}/todos/{id}")
	private Todo retrieveTodo(@PathVariable String username, @PathVariable int id) {
		return todoService.findById(id);
	}

	@DeleteMapping("/users/{username}/todos/{id}")
	private ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
		todoService.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/{username}/todos/{id}")
	private Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
		todoService.updateTodo(todo);

		return todo;
	}

	@PostMapping("/users/{username}/todos")
	private Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
		Todo createdTodo = todoService.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());

		return createdTodo;
	}

}
