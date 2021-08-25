package com.example.springtodoapp.repository;

import com.example.springtodoapp.model.TodoApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoAppRepository extends CrudRepository<TodoApp, Integer> { }
