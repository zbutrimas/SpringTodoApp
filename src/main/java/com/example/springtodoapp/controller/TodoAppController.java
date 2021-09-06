package com.example.springtodoapp.controller;


import com.example.springtodoapp.model.TodoApp;
import com.example.springtodoapp.repository.TodoAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/main")
//@CrossOrigin(origins = "*", maxAge = 3600) //tinka bet kokiam portui
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TodoAppController {

    @Autowired
    private TodoAppRepository tar;

    @GetMapping("/todo")
    public Iterable<TodoApp> getAllTodoApps() {
        return tar.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/todo/{id}")
    public TodoApp getAllTodoApp(@PathVariable Integer id) {
        return tar.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    // add todoApp
    @RequestMapping(
            method = RequestMethod.POST,
            path = "/todo",
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<String> addTodoApp(
            @RequestBody TodoApp postApp)
    {
        tar.save(postApp);
        return new ResponseEntity<>(HttpStatus.CREATED); // 201
    }
    //            @RequestBody Map<String> params )
//        tar.save(new TodoApp(params.get("cardText")));
//    return new ResponseEntity<>(HttpStatus.CREATED);

    // delete todoApp
//    @RequestMapping(method = RequestMethod.DELETE, path="/todo/{id}")
//    public Map deleteTodoApp(@PathVariable String id) {
//        Map postsApp = null;
//        postsApp.remove(id);
//        return postsApp;
//    }
}
