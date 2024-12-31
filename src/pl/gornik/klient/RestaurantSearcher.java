package pl.gornik.klient;

import pl.gornik.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class RestaurantSearcher {
    private List<Restaurant> restaurants;

    public RestaurantSearcher() {
        restaurants = new ArrayList<>();
    }

    // dodawanie restauracji do wyszukania
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
