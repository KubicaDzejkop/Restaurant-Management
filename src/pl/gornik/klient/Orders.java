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

    // dodawanie zamowionego dania oraz zliczanie ceny za to danie
    public void addOrderItem(OrderItem item) {
        orderItems.add(item);
        totalPrice += item.getDish().getPrice() * item.getQuantity();
    }

    // pobieranie zamowionych dan
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    // pobieranie calkowitej ceny za zamowione danie
    public double getTotalPrice() {
        return totalPrice;
    }
}

