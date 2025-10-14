package com.example.toDoList.service;

import com.example.toDoList.model.ToDoList;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class ToDoListService{
    private List<ToDoList> todos = new ArrayList<>();
    private int nextId = 1;

    public List<ToDoList> getAllToDoLists(){ return todos; }

    public ToDoList addTodo(String title){
        ToDoList todo = new ToDoList(nextId++, title, false);
        todos.add(todo);
        return todo;
    }

    public boolean deleteToDo(int id){
        return todos.removeIf(todo -> todo.getId() == id);
    }

}