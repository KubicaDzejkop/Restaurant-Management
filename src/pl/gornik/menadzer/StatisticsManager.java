package pl.gornik.menadzer;

import pl.gornik.klient.OrderItem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticsManager {
    private List<OrderItem> orderedDishes;
    private List<String> peakHours;

    public StatisticsManager() {
        this.orderedDishes = new ArrayList<>();
        this.peakHours = new ArrayList<>();
    }

    // Metoda do dodawania zamowionych dań
    public void addOrderedDish(OrderItem orderItem) {
        orderedDishes.add(orderItem);
    }

    // Metoda do dodawania godzin największego ruchu
    public void addPeakHour(String peakHour) {
        peakHours.add(peakHour);
    }

    // Metoda do odczytu zamówionych dań
    public List<String> getOrderedDishesSorted() {
        Map<String, Integer> dishCounts = new HashMap<>();
        for (OrderItem orderItem : orderedDishes) {
            String dishName = orderItem.getDish().getName();
            dishCounts.put(dishName, dishCounts.getOrDefault(dishName, 0) + orderItem.getQuantity());
        }

        // Sortowanie dań po liczbie zamówień
        List<Map.Entry<String, Integer>> sortedDishes = new ArrayList<>(dishCounts.entrySet());

        sortedDishes.sort(new java.util.Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
                return entry2.getValue() - entry1.getValue();
            }
        });

        List<String> sortedDishNames = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedDishes) {
            sortedDishNames.add(entry.getKey() + " - " + entry.getValue() + " razy");
        }
        return sortedDishNames;
    }

    // Metoda do odczytu godzin z największym ruchem
    public List<String> getPeakHours() {
        return peakHours;
    }
}
