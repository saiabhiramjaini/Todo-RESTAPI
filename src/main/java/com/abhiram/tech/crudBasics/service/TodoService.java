package com.abhiram.tech.crudBasics.service;

import com.abhiram.tech.crudBasics.model.Todo;
import com.abhiram.tech.crudBasics.repository.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepo repo;

    public List<Todo> getTodos() {
        return repo.findAll();
    }

    public Todo addTodo(Todo todo) {
        return repo.save(todo);
    }

    public Todo getTodoById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    public Todo updateTodo(Integer id, Todo todo) {
        todo.setId(id);
        return repo.save(todo);
    }

    public String deleteTodo(Integer id) {
        repo.deleteById(id);
        return "Todo deleted successfully";
    }
}