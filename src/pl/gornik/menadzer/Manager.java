package pl.gornik.menadzer;

import pl.gornik.autentykacja.Credentials;
import pl.gornik.autentykacja.User;

public class Manager extends User{

    public Manager(Credentials credentials, String email) {
        super(credentials, email);
    }
    @Override
    public String getUserType() {
        return "Manager";
    }
}
