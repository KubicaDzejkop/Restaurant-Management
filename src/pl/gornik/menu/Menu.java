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

    public void addDish(Dishes dish) {
        dishes.add(dish);
    }

    public void removeDish(Dishes dish) {
        dishes.remove(dish);
    }
    public List<Dishes> getDishes(){
        return dishes;
    }
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

