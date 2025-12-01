package com.abhiram.tech.crudBasics.controller;

import com.abhiram.tech.crudBasics.model.Todo;
import com.abhiram.tech.crudBasics.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getTodos() {
        List<Todo> todos = todoService.getTodos();
        return ResponseEntity.ok(todos);
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo) {
        Todo createdTodo = todoService.addTodo(todo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTodo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Integer id) {
        Todo todo = todoService.getTodoById(id);
        if (todo == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(todo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Integer id, @RequestBody Todo todo) {
        Todo updatedTodo = todoService.updateTodo(id, todo);
        return ResponseEntity.ok(updatedTodo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Integer id) {
        String message = todoService.deleteTodo(id);
        return ResponseEntity.ok(message);
    }
}