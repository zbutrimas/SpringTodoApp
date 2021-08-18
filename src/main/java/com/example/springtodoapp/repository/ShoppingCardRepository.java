package com.example.springtodoapp.repository;

import com.example.springtodoapp.model.ShoppingCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCardRepository extends JpaRepository<ShoppingCard, Long> {
    void deleteShoppingCardById(Long id);

}
