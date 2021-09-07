package com.example.springtodoapp.repository;

import com.example.springtodoapp.model.TodoApp;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface TodoAppRepository extends CrudRepository<TodoApp, Integer> {

    void deleteById(Integer id);
}
