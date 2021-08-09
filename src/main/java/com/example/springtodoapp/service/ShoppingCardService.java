package com.example.springtodoapp.service;

import com.example.springtodoapp.model.ShoppingCard;
import com.example.springtodoapp.repository.ShoppingCardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShoppingCardService {
    private final ShoppingCardRepo shoppingCardRepo;
    @Autowired
    public ShoppingCardService(ShoppingCardRepo shoppingCardRepo) { this.shoppingCardRepo = shoppingCardRepo;}

    public ShoppingCard addShoppingCard(ShoppingCard shoppingCard){
        shoppingCard.setCardText(UUID.randomUUID().toString());
        return shoppingCardRepo.save(shoppingCard);
    }
    public void deleteShoppingCard(Long id){
        shoppingCardRepo.deleteShoppingCard(id);

    }
}
