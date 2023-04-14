package com.azcona.restapi.todoapp.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.azcona.restapi.todoapp.todo.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
