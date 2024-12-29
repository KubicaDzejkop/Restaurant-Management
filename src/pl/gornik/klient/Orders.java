package pl.gornik.klient;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private Client client;
    private List<OrderItem> orderItems;
    private double totalPrice;

    public Orders(Client client) {
        this.client = client;
        this.orderItems = new ArrayList<>();
        this.totalPrice = 0.0;
    }

    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
        totalPrice += item.getDish().getPrice() * item.getQuantity();
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}

