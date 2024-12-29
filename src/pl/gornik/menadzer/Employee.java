package pl.gornik.menadzer;

import pl.gornik.autentykacja.Credentials;
import pl.gornik.autentykacja.User;

public class Employee {
    private String firstName;
    private String lastName;
    private String email;
    private Credentials credentials;
    private String position;

    public Employee(String firstName, String lastName, String email, Credentials credentials, String position) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.credentials = credentials;
        this.position = position;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getEmail() {
        return email;
    }
    public Credentials getCredentials(){
        return credentials;
    }
    public String getPosition() {
        return position;
    }
}
