package com.example.springtodoapp.controller;

import com.example.springtodoapp.model.ShoppingCard;
import com.example.springtodoapp.service.ShoppingCardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shoppingCard")
public class ShoppingCardController {
    private final ShoppingCardService shoppingCardService;

    public ShoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }

    @PostMapping("/add")
    public ResponseEntity<ShoppingCard> addShoppingCard(@RequestBody ShoppingCard shoppingCard) {
        ShoppingCard newShoppingCard = shoppingCardService.addShoppingCard(shoppingCard);
        return new ResponseEntity<>(newShoppingCard, HttpStatus.CREATED);
    }

    @Transactional
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteShoppingCard(@PathVariable("id") Long id) {
        shoppingCardService.deleteShoppingCard(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
