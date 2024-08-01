package org.example.exercice1.controller;


import org.example.exercice1.model.Todo;
import org.example.exercice1.service.TodoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    //@RequestMapping("/")
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/todos")
    public String getAllTodos(Model model){
        model.addAttribute("todos",todoService.getTodos());
        return "todos";
    }

    @GetMapping("/todosjson")
    @ResponseBody
    public ArrayList<Todo> getAllTodosJson(){
        return todoService.getTodos();
    }

    @GetMapping("/todo")
    public String getOneTodo(Model model){
        Todo todo = new Todo("name1","description42",false);
        model.addAttribute("titre",todo.getName());
        model.addAttribute("description",todo.getDescription());
        if (todo.isDone()){
            model.addAttribute("status","fini");
        }else {
            model.addAttribute("status","en cours");
        }
        model.addAttribute("todo",new Todo("name2","description43",true));
        return "todo";
    }


}
