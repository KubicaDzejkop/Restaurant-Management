package pl.gornik.menadzer;

import pl.gornik.Restaurant;

import java.util.List;

public class StaffManager {
    public void addEmployee(Restaurant restaurant, Employee employee) {
        restaurant.addEmployee(employee);
    }

    public void removeEmployee(Restaurant restaurant, Employee employee) {
        restaurant.removeEmployee(employee);
    }
    public List<Employee> getAllEmployees(Restaurant restaurant){
        return restaurant.getEmployees();
    }
}
