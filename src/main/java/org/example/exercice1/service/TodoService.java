package org.example.exercice1.service;

import lombok.Getter;
import lombok.Setter;
import org.example.exercice1.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Getter
@Setter
public class TodoService {

    private ArrayList<Todo> todos = new ArrayList<>();

    public TodoService(){
        this.todos.add(new Todo("todo1","description1",true));
        this.todos.add(new Todo("todo2","description2",false));
        this.todos.add(new Todo("todo3","description3",true));
    }
}
