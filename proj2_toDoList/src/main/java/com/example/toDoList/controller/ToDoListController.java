package com.example.toDoList.controller;

import com.example.toDoList.model.ToDoList;
import com.example.toDoList.service.ToDoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/todos")
public class ToDoListController {

    @Autowired
    private ToDoListService toDoListService;

    @GetMapping
    public List<ToDoList> getTodos() {
        return toDoListService.getAllToDoLists();
    }

    @PostMapping
    public ToDoList createTodo(@RequestBody Map<String, String> body) {
        String title = body.get("title");
        return toDoListService.addTodo(title);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable int id) {
        boolean removed = toDoListService.deleteToDo(id);
        if (removed) {
            return ResponseEntity.ok("Todo deleted");
        }
        return ResponseEntity.notFound().build();
    }
}