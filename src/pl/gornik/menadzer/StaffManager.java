package pl.gornik.menadzer;

import pl.gornik.Restaurant;

import java.util.List;

public class StaffManager {

    // dodawanie nowego pracownika do restauracji
    public void addEmployee(Restaurant restaurant, Employee employee) {
        restaurant.addEmployee(employee);
    }

    // usuwanie pracownika z restauracji
    public void removeEmployee(Restaurant restaurant, Employee employee) {
        restaurant.removeEmployee(employee);
    }

    // wyswietlanie wszystkich pracownikow w restauracji, ktorzy pracuja
    public List<Employee> getAllEmployees(Restaurant restaurant) {
        return restaurant.getEmployees();
    }
}
