package pl.gornik.klient;

import pl.gornik.autentykacja.Credentials;
import pl.gornik.autentykacja.User;

public class Client extends User {
    private String firstName;
    private String lastName;

    public Client(String firstName, String lastName, Credentials credentials, String email) {
        super(credentials, email);
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    @Override
    public String getUserType() {
        return "Client";
    }
}
