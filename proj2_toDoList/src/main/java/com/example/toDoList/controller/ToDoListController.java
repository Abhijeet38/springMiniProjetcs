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

    @GetMapping("/{id}")
    public ToDoList getOneToDoList(@PathVariable Long id) {
        return toDoListService.getOneToDoList(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ToDoList> updateTodo(@PathVariable Long id, @RequestBody Map<String,String> body){
        String title = body.get("title");
        ToDoList todo = toDoListService.updateToDoList(id, title);
        if (todo != null){
            return ResponseEntity.ok(todo);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/completed")
    public ResponseEntity<ToDoList> updateCompleted(@PathVariable Long id){
        ToDoList todo = toDoListService.updateCompleted(id);
        if (todo != null){
            return ResponseEntity.ok(todo);
        }
        return ResponseEntity.notFound().build();
    }


    @PostMapping
    public ToDoList createTodo(@RequestBody Map<String, String> body) {
        String title = body.get("title");
        return toDoListService.addTodo(title);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable Long id) {
        boolean removed = toDoListService.deleteToDo(id);
        if (removed) {
            return ResponseEntity.ok("Todo deleted");
        }
        return ResponseEntity.notFound().build();
    }
}