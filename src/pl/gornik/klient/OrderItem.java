package pl.gornik.klient;

import pl.gornik.menu.Dishes;

public class OrderItem {
    private Dishes dish;
    private int quantity;

    public OrderItem(Dishes dish, int quantity) {
        this.dish = dish;
        this.quantity = quantity;
    }

    public Dishes getDish() {
        return dish;
    }

    public int getQuantity() {
        return quantity;
    }
}