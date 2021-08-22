package com.example.springtodoapp.controller;


import com.example.springtodoapp.model.ShoppingCard;
import com.example.springtodoapp.service.ShoppingCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shopping-card")
public class ShoppingCardController {

    private final ShoppingCardService shoppingCardService;

    @Autowired
    public ShoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ShoppingCard>> getShoppingCard() {
        List<ShoppingCard> shoppingCards = shoppingCardService.findAllShoppingCards();
        return new ResponseEntity<>(shoppingCards, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ShoppingCard> addShoppingCard (@RequestBody ShoppingCard shoppingCard) {
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
