package com.example.springtodoapp.service;

import com.example.springtodoapp.model.ShoppingCard;
import com.example.springtodoapp.repository.ShoppingCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ShoppingCardService {

    private final ShoppingCardRepository shoppingCardRepository;

    @Autowired
    public ShoppingCardService(ShoppingCardRepository shoppingCardRepository) {
        this.shoppingCardRepository = shoppingCardRepository;
    }

    public ShoppingCard createShoppingCard(ShoppingCard shoppingCard) {
        return shoppingCardRepository.save(shoppingCard);
    }

    public ShoppingCard deleteShoppingCard() {
        return null;
    }

    public List<ShoppingCard> getShoppingCard() {
        return shoppingCardRepository.findAll();
    }
}
