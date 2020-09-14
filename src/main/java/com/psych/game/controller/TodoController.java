package com.psych.game.controller;

import com.psych.game.model.*;
import com.psych.game.repository.TasksRepository;
import com.psych.game.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dev")
public class TodoController {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TasksRepository taskRepository;

    @GetMapping("/todo")
    public List<Todo> getAlltodos() {
        return todoRepository.findAll();
    }

    @GetMapping("/GetTodoById/{id}")
    public Todo getAllPlayers(@PathVariable Long id) throws Exception {
        Todo to = todoRepository.findById(id).orElse(null);
        return to;
    }

    @PostMapping("/todo")
    public Todo postTodo(@RequestBody Todo TodoList) throws Exception {
        Todo _todo = new Todo();
        _todo.name = TodoList.name;
        _todo.description = TodoList.description;
        List<Tasks> taskList = TodoList.task;
        List<Tasks> Alltasks = new ArrayList<Tasks>();
        for(Tasks myTask : taskList){
            myTask = taskRepository.save(myTask);
            Alltasks.add(myTask);
        }
        _todo.task = Alltasks;
        _todo = todoRepository.save(_todo);
        return _todo;
    }

    @PutMapping("/todo")
    public Todo PutTodo(@RequestBody taskEdit taskadd){
        Todo to = todoRepository.findById(taskadd.id).orElse(null);
        List<Tasks> MainTaskList = to.task;
        List<Tasks> taskList = taskadd.task;
        for(Tasks myTask : taskList){
            myTask = taskRepository.save(myTask);
            MainTaskList.add(myTask);
        }
        to.task = MainTaskList;
        to = todoRepository.save(to);
        return to;
    }

    @DeleteMapping("/todo")
    public Todo DelTodo(@RequestBody taskDel taskdel){
        Todo to = todoRepository.findById(taskdel.id).orElse(null);
        List<Tasks> taskList = to.task;
        List<Tasks> newList = new ArrayList<Tasks>();
        Tasks Deltask = null;
        for(Tasks tas : taskList){
            if(tas.id == taskdel.Sid){
                Deltask = tas;
                continue;
            }
            newList.add(tas);
        }
        if(Deltask == null) return to;
        to.task = newList;
        to = todoRepository.save(to);
        return to;
    }
    @DeleteMapping("/MainTodo/{id}")
    public String DelMainTask(@PathVariable Long id) throws Exception{
        todoRepository.deleteById(id);
        return "success";
    }
}
