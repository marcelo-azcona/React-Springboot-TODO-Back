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

import com.azcona.restapi.todoapp.todo.repository.TodoRepository;

@RestController
public class TodoJpaResource {

	private TodoRepository todoRepository;

	public TodoJpaResource(TodoRepository aTodoRepository) {
		super();
		this.todoRepository = aTodoRepository;
	}

	@GetMapping("/users/{username}/todos")
	private List<Todo> retrieveTodos(@PathVariable String username) {
		return todoRepository.findByUsername(username);
	}

	@GetMapping("/users/{username}/todos/{id}")
	private Todo retrieveTodo(@PathVariable String username, @PathVariable int id) {
		return todoRepository.findById(id).get();
	}

	@DeleteMapping("/users/{username}/todos/{id}")
	private ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id) {
		todoRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/users/{username}/todos/{id}")
	private Todo updateTodo(@PathVariable String username, @PathVariable int id, @RequestBody Todo todo) {
		todoRepository.save(todo);

		return todo;
	}

	@PostMapping("/users/{username}/todos")
	private Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
		todo.setUsername(username);
		todo.setId(null);

		return todoRepository.save(todo);
	}

}
