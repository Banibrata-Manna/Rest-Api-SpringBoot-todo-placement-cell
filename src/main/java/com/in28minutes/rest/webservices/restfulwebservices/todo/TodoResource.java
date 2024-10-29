package com.in28minutes.rest.webservices.restfulwebservices.todo;

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
	private TodoService service;
	
	public TodoResource(TodoService service) {
		this.service = service;
	}
	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTodos(@PathVariable("username") String username) {
		return service.findByUsername(username);
	}
	@GetMapping("/users/{username}/todos/{id}")
	public Todo retrieveTodo (@PathVariable("username") String username,
			@PathVariable("id") int id) {
		return service.findById(id);
	}
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo (@PathVariable("username") String username,
			@PathVariable("id") int id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	@PutMapping("/users/{username}/todos/{id}")
	public Todo updateTodo(@PathVariable("username") String username,
			@PathVariable("id") int id, @RequestBody Todo todo) {
		service.updateTodo(todo);
		return todo;
	}
	@PostMapping("/users/{username}/todos")
	public Todo createTodo(@PathVariable("username") String username,
			@RequestBody Todo todo) {
		Todo createdTodo = service.addTodo(username, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return createdTodo;
	}
}
