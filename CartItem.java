package com.example.pizzajava;

import java.io.Serializable;

public class CartItem implements Serializable {
    private Pizza pizza;
    private int quantity;

    public CartItem(Pizza pizza, int quantity) {
        this.pizza = pizza;
        this.quantity = quantity;
    }

    // Геттеры и сеттеры
}
