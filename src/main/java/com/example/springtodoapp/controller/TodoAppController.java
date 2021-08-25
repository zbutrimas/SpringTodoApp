package com.example.springtodoapp.controller;


import com.example.springtodoapp.model.TodoApp;
import com.example.springtodoapp.repository.TodoAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
//@CrossOrigin(origins = "*", maxAge = 3600) //tinka bet kokiam portui
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TodoAppController {

    @Autowired
    public TodoAppRepository tar;

    @GetMapping("/todo")
    public Iterable<TodoApp> getAllTodoApps() {
        return tar.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/todo/{id}")
    public TodoApp getAllTodoApps(@PathVariable Integer id) {
        System.out.println("getAllTodoApps /todo{" + id + "} hit");
        return tar.findById(id).get();
    }

    @RequestMapping (
            method = RequestMethod.POST,
            path = "/todos",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE
    )
    public ResponseEntity<String> addTodoApp(
            @RequestParam("cardText") String cardText) {
        tar.save(new TodoApp(cardText));
        return new ResponseEntity<>(HttpStatus.CREATED); // 201
    }
}
