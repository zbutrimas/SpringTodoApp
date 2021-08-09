package com.example.springtodoapp.repository;

import com.example.springtodoapp.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCardRepo extends JpaRepository<ShoppingCard, Long> {
    void deleteShoppingCard(Long id);
}
