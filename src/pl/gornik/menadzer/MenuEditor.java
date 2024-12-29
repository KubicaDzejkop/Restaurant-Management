package pl.gornik.menadzer;

import pl.gornik.menu.Dishes;
import pl.gornik.menu.Menu;

public class MenuEditor {

    // dodawanie dań
    public void addDish(Menu menu, Dishes dish) {
        menu.addDish(dish);
    }

    // usuwanie dań
    public void removeDish(Menu menu, Dishes dish) {
        menu.removeDish(dish);
    }

    // aktualizowanie cen dań
    public void updateDishPrice(Menu menu, String dishName, double newPrice) {
        for (Dishes dish : menu.getDishes()) {
            if (dish.getName().equals(dishName)) {
                dish.setPrice(newPrice);
                return;
            }
        }
    }
}
