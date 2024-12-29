package pl.gornik;

import pl.gornik.menadzer.Employee;
import pl.gornik.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
        private String name;
        private Menu menu;
        private List<String> reviews;
        private List<Employee> employees;

        public Restaurant(String name){
            this.name = name;
            this.menu = new Menu();
            this.reviews = new ArrayList<>();
            this.employees = new ArrayList<>();
        }
        public String getName(){
            return name;
        }
        public Menu getMenu() {
            return menu;
        }

        public void addReview(String review) {
            reviews.add(review);
        }

        public List<String> getReviews() {
            return reviews;
        }
        public void addEmployee(Employee employee){
            employees.add(employee);
        }
        public void removeEmployee(Employee employee){
            employees.remove(employee);
        }
        public List<Employee> getEmployees(){
            return employees;
        }
}
