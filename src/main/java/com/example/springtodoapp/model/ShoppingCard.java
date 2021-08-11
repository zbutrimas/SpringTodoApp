package com.example.springtodoapp.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


public class ShoppingCard implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String cardText;

    public ShoppingCard (){
    }

    public ShoppingCard(Long id, String cardText) {
        this.id = id;
        this.cardText = cardText;
    }

    public ShoppingCard(String cardText) {
        this.cardText = cardText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardText() {
        return cardText;
    }

    public void setCardText(String cardText) {
        this.cardText = cardText;
    }

    @Override
    public String toString() {
        return "ShoppingCard{" +
                "id=" + id +
                ", cardText='" + cardText + '\'' +
                '}';
    }
}
