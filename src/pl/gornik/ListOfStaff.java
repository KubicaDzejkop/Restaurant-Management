package pl.gornik;

import pl.gornik.menadzer.Employee;

import java.util.ArrayList;
import java.util.List;

public class ListOfStaff {
    private List<Employee> staffList;

    public ListOfStaff() {
        staffList = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        staffList.add(employee);
    }

    public void removeEmployee(Employee employee) {
        staffList.remove(employee);
    }

}
