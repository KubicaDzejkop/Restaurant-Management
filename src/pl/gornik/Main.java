package pl.gornik;

import pl.gornik.autentykacja.Authenticator;
import pl.gornik.autentykacja.Credentials;
import pl.gornik.klient.Client;
import pl.gornik.klient.RestaurantSearcher;

public class Main {
    public static void main(String[] args) {
        Authenticator authenticator = new Authenticator();
        RestaurantSearcher restaurantSearcher = new RestaurantSearcher();
        Restaurant restaurant = new Restaurant("Restauracja Allette Coccolini");
        ListOfStaff listOfStaff = new ListOfStaff();

        // przykladowy klient
        Credentials credentialsClient1 = new Credentials("janek", "haslo123");
        Client client1 = new Client("Jan", "Kowalski", credentialsClient1, "jan@example.com");
        authenticator.registerUser(client1);
    }
}