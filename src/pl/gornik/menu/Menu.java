package pl.gornik.menu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Menu {
    private List<Dishes> dishes;

    public Menu() {
        this.dishes = new ArrayList<>();
    }

    // dodawanie dania
    public void addDish(Dishes dish) {
        dishes.add(dish);
    }

    // usuwanie dania
    public void removeDish(Dishes dish) {
        dishes.remove(dish);
    }

    // wszystkie dania
    public List<Dishes> getDishes() {
        return dishes;
    }

    // metoda do odczytu dan po kategorii
    public List<Dishes> getDishesByCategory(String category) {
        List<Dishes> filteredDishes = new ArrayList<>();
        for (Dishes dish : dishes) {
            if (dish.getCategory().equals(category)) {
                filteredDishes.add(dish);
            }
        }
        return filteredDishes;
    }
}

