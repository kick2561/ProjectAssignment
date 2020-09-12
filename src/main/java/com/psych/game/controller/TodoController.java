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

    @GetMapping("/todoById")
    public Todo getAllPlayers(@RequestBody Todo tod) throws Exception {
        Todo to = todoRepository.findById(tod.id).orElse(null);
        return to;
    }

    @PostMapping("/todo")
    public Todo postTodo(@RequestBody tasktodo tasks) throws Exception {
        Todo _todo = new Todo();
        _todo.name = tasks.Name;
        _todo.description = tasks.Description;
        Tasks newTask = new Tasks();
        newTask.name = tasks.taskName;
        newTask.description = tasks.taskDescription;
        newTask = taskRepository.save(newTask);
        List<Tasks> Alltasks = new ArrayList<Tasks>();
        Alltasks.add(newTask);
        _todo.task = Alltasks;
        _todo = todoRepository.save(_todo);
        return _todo;
    }

    @PutMapping("/todo")
    public Todo PutTodo(@RequestBody taskEdit taskadd){
        Todo to = todoRepository.findById(taskadd.id).orElse(null);
        List<Tasks> taskList = to.task;
        Tasks newTask = new Tasks();
        newTask.name = taskadd.taskName;
        newTask.description = taskadd.taskDescription;
        newTask = taskRepository.save(newTask);
        taskList.add(newTask);
        to.task = taskList;
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
    @DeleteMapping("/Maintodo")
    public String DelMainTask(@RequestBody  Todo to){
        todoRepository.deleteById(to.id);
        return "success";
    }
}
