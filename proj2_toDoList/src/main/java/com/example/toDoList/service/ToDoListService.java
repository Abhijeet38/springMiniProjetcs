package com.example.toDoList.service;

import com.example.toDoList.model.ToDoList;
import org.springframework.stereotype.Service;
import com.example.toDoList.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.ArrayList;

@Service
public class ToDoListService{

    @Autowired
    private TodoRepository todoRepository;

    public List<ToDoList> getAllToDoLists(){ return todoRepository.findAll(); }
    public ToDoList getOneToDoList(Long id){ return todoRepository.findById(id).orElse(null); }

    public ToDoList updateCompleted(Long id){
        ToDoList todo = todoRepository.findById(id).orElse(null);
        if (todo != null){
            todo.setCompleted(true);
            return todoRepository.save(todo);
        }
        return null;
    }

    public ToDoList updateToDoList(Long id, String title){
        ToDoList todo = todoRepository.findById(id).orElse(null);
        if (todo != null){
            todo.setTitle(title);
            return todoRepository.save(todo);
        }
        return null;
    }

    public ToDoList addTodo(String title){
        ToDoList todo = new ToDoList(title, false);
        return todoRepository.save(todo);
    }

    public boolean deleteToDo(Long id){
        if (todoRepository.existsById(id)){
            todoRepository.deleteById(id);
            return true;
        }
        return false;
    }

}