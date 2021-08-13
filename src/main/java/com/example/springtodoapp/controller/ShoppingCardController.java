package com.example.springtodoapp.controller;


import com.example.springtodoapp.model.ShoppingCard;
import com.example.springtodoapp.service.ShoppingCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/home/shoppingCard")
public class ShoppingCardController {

    private final ShoppingCardService shoppingCardService;
    public ShoppingCardController(ShoppingCardService shoppingCardService) {
        this.shoppingCardService = shoppingCardService;
    }

    @GetMapping
    public List<ShoppingCard> getShoppingCard() {
        return shoppingCardService.getShoppingCard();
    }

    @PostMapping
    public void createShoppingCard(@RequestBody ShoppingCard shoppingCard) {
        shoppingCardService.createShoppingCard(shoppingCard);
    }

    @DeleteMapping
    public String deleteShoppingCard() {
        return null;
    }

}
