package pl.gornik;

import pl.gornik.autentykacja.*;
import pl.gornik.klient.*;
import pl.gornik.menu.*;
import pl.gornik.menadzer.*;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class Main {
    private static final String LOGIN_MESSAGE = "Wybierz opcję: ";
    private static StaffManager staffManager = new StaffManager();
    private static MenuEditor menuEditor = new MenuEditor();
    private static StatisticsManager statisticsManager = new StatisticsManager();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        System.out.println("Witamy w systemie zamówień restauracji!");
        System.out.println("Aby się zalogować, użyj następujących danych:");
        System.out.println("Klient:");
        System.out.println("  Login: janek, Hasło: haslo123");
        System.out.println("Menadżer:");
        System.out.println("  Login: admin, Hasło: admin123");
        System.out.println("----------------------------------------------");

        // Inicjalizacja serwisów i restauracji
        Authenticator authenticator = new Authenticator();
        Restaurant restaurant = new Restaurant("Pyszna restauracja");
        ListOfStaff listOfStaff = new ListOfStaff();

        // Rejestracja przykładowych użytkowników
        Credentials credentialsClient1 = new Credentials("janek", "haslo123");
        Client client1 = new Client("Jan", "Kowalski", credentialsClient1, "jan@gmail.com");
        authenticator.registerUser(client1);
        Credentials credentialsManager1 = new Credentials("admin", "admin123");
        Manager manager1 = new Manager(credentialsManager1, "admin@gmail.com");
        authenticator.registerUser(manager1);

        // Dodanie przykładowych dań do menu restauracji
        Dishes dish1 = new Dishes("Kotlet Schabowy", "Dania główne", 20.0);
        Dishes dish2 = new Dishes("Pierogi Ruskie", "Dania główne", 16.50);
        Dishes dish3 = new Dishes("Tiramisu", "Desery", 15.0);
        Dishes dish4 = new Dishes("Szarlotka", "Desery", 12.0);
        Dishes dish5 = new Dishes("Cola", "Napoje", 6.0);
        Dishes dish6 = new Dishes("Herbata", "Napoje", 4.0);
        Dishes dish7 = new Dishes("Woda gazowana", "Napoje", 5.0);
        Dishes dish8 = new Dishes("Woda niegazowana", "Napoje", 4.50);
        Dishes dish9 = new Dishes("Zupa grochowa", "Zupa", 18.0);
        Dishes dish10 = new Dishes("Rosół", "Zupa", 15.0);
        Dishes dish11 = new Dishes("Tortilki", "Przystawka", 2.0);
        Dishes dish12 = new Dishes("Jajka w majonezie", "Przystawka", 4.0);
        Dishes dish13 = new Dishes("Karkówka", "Dania główne", 25.0);
        Dishes dish14 = new Dishes("Wątróbka", "Dania główne", 23.0);
        Dishes dish15 = new Dishes("Zupa pomidorowa", "Zupa", 15.0);
        restaurant.getMenu().addDish(dish1);
        restaurant.getMenu().addDish(dish2);
        restaurant.getMenu().addDish(dish3);
        restaurant.getMenu().addDish(dish4);
        restaurant.getMenu().addDish(dish5);
        restaurant.getMenu().addDish(dish6);
        restaurant.getMenu().addDish(dish7);
        restaurant.getMenu().addDish(dish8);
        restaurant.getMenu().addDish(dish9);
        restaurant.getMenu().addDish(dish10);
        restaurant.getMenu().addDish(dish11);
        restaurant.getMenu().addDish(dish12);
        restaurant.getMenu().addDish(dish13);
        restaurant.getMenu().addDish(dish14);
        restaurant.getMenu().addDish(dish15);

        // Dodanie przykładowych opinii
        restaurant.addReview("Bardzo smaczne dania!");
        restaurant.addReview("Obsługa trochę powolna.");

        // Dodanie pracowniko
        Credentials credentialsEmployee1 = new Credentials("employee1", "haslo123");
        Employee employee1 = new Employee("Adam", "Nowak", "adam23@gmail.com", credentialsEmployee1, "Kucharz");
        Employee employee2 = new Employee("Krystian", "Kownacki", "krystian1@gmail.com", credentialsEmployee1, "Kelner");
        listOfStaff.addEmployee(employee1);
        listOfStaff.addEmployee(employee2);
        restaurant.addEmployee(employee1);
        restaurant.addEmployee(employee2);

        // Pętla główna programu
        while (true) {
            String[] options = {"Zaloguj się", "Zarejestruj się", "Wyjdź"};
            displayMenu(LOGIN_MESSAGE, options);
            int choice = getMenuChoice(LOGIN_MESSAGE, 1, options.length);
            switch (choice) {
                case 1:
                    System.out.print("Login: ");
                    String login = scanner.nextLine();
                    System.out.print("Hasło: ");
                    String password = scanner.nextLine();
                    try {
                        User loggedInUser = authenticator.login(login, password);
                        System.out.println("Zalogowano jako: " + loggedInUser.getUserType());
                        if (loggedInUser instanceof Client client) {
                            handleClientActions(client, restaurant);
                        } else if (loggedInUser instanceof Manager) {
                            handleManagerActions(restaurant, listOfStaff);
                        }
                    } catch (LoginException e) {
                        System.out.println("Błąd logowania:" + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Imię: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Nazwisko: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Login: ");
                    String newLogin = scanner.nextLine();
                    System.out.print("Hasło: ");
                    String newPassword = scanner.nextLine();
                    System.out.print("Email: ");
                    String newEmail = scanner.nextLine();
                    Credentials newCredentials = new Credentials(newLogin, newPassword);
                    Client newClient = new Client(firstName, lastName, newCredentials, newEmail);
                    authenticator.registerUser(newClient);
                    System.out.println("Zarejestrowano pomyślnie.");
                    break;
                case 3:
                    System.out.println("Do widzenia!");
                    return;
                default:
                    System.out.println("Niepoprawny wybór.");
            }
        }
    }

    // Wyświetlenie menu
    private static void displayMenu(String title, String[] options) {
        System.out.println("\n" + title);
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
    }

    // wybranie pozycji menu
    private static int getMenuChoice(String prompt, int min, int max) {
        int choice;
        while (true) {
            System.out.print(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Niepoprawna wartość. Podaj liczbę całkowitą.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice >= min && choice <= max) {
                return choice;
            } else {
                System.out.println("Niepoprawny wybór. Spróbuj ponownie.");
            }
        }
    }

    // Menu dla klienta
    public static void handleClientMenuNavigation(Client client, Restaurant restaurant, Orders order, Menu menu) {
        while (true) {
            String[] options = {"Zobacz opinie restauracji", "Zobacz menu restauracji", "Wyloguj się"};
            displayMenu("Wybierz opcję:", options);
            int choice = getMenuChoice("Wybierz opcję:", 1, options.length);
            switch (choice) {
                case 1:
                    System.out.println("Opinie restauracji: ");
                    for (String review : restaurant.getReviews()) {
                        System.out.println("- " + review);
                    }
                    break;
                case 2:
                    handleClientMenu(menu, client, order);
                    break;
                case 3:
                    System.out.println("Wylogowano.");
                    return;
                default:
                    System.out.println("Niepoprawny wybór");
            }
        }
    }

    // powitanie klienta i wyswietlenie mu menu klienta
    public static void handleClientActions(Client client, Restaurant restaurant) {
        System.out.println("Witaj, " + client.getFirstName() + " " + client.getLastName());
        Orders order = new Orders(client);
        Menu menu = restaurant.getMenu();
        handleClientMenuNavigation(client, restaurant, order, menu);

    }

    // Metoda obsługi menu klienta
    public static void handleClientMenu(Menu menu, Client client, Orders order) {
        while (true) {
            String[] options = {"Desery", "Dania główne", "Napoje", "Przystawki", "Zupy", "Powrót do poprzedniego menu"};
            displayMenu("Menu:", options);
            int categoryChoice = getMenuChoice("Wybierz kategorię: ", 1, options.length);
            switch (categoryChoice) {
                case 1:
                    handleCategoryMenu(menu, "Desery", client, order);
                    break;
                case 2:
                    handleCategoryMenu(menu, "Dania główne", client, order);
                    break;
                case 3:
                    handleCategoryMenu(menu, "Napoje", client, order);
                    break;
                case 4:
                    handleCategoryMenu(menu, "Przystawka", client, order);
                    break;
                case 5:
                    handleCategoryMenu(menu, "Zupa", client, order);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Niepoprawny wybór.");
            }
        }
    }

    // Metoda obsługi menu kategorii
    public static void handleCategoryMenu(Menu menu, String category, Client client, Orders order) {
        System.out.println("\nWybrana kategoria: " + category);
        List<Dishes> dishes = menu.getDishesByCategory(category);
        displayMenuItems(dishes);
        boolean ordering = false;
        while (!ordering) {
            System.out.print("Czy chcesz przejść do zamówienia? (tak/nie)");
            String orderChoice = scanner.nextLine();
            if (orderChoice.equalsIgnoreCase("tak")) {
                ordering = true;
                handleOrder(dishes, client, menu, order);
            } else if (orderChoice.equalsIgnoreCase("nie")) {
                return;
            } else {
                System.out.println("Niepoprawny wybór");
            }
        }
    }

    // Metoda obsługi zamówienia
    public static void handleOrder(List<Dishes> dishes, Client client, Menu menu, Orders order) {
        boolean addMoreItems = true;
        while (addMoreItems) {
            System.out.println("Wybierz danie po nazwie z menu: ");
            displayMenuItems(dishes);
            System.out.print("Nazwa dania: ");
            String menuItemName = scanner.nextLine();
            Dishes selectedMenuItem = null;
            for (Dishes item : dishes) {
                if (item.getName().equalsIgnoreCase(menuItemName)) {
                    selectedMenuItem = item;
                    break;
                }
            }
            if (selectedMenuItem != null) {
                System.out.print("Ile sztuk?: ");
                int quantity = scanner.nextInt();
                scanner.nextLine();
                OrderItem orderItem = new OrderItem(selectedMenuItem, quantity);
                order.addOrderItem(orderItem);
                System.out.print("Czy chcesz dodać jeszcze jedno danie? (tak/nie)");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("tak")) {
                    handleClientMenu(menu, client, order);
                    return;
                } else if (choice.equalsIgnoreCase("nie")) {
                    break;
                } else {
                    System.out.println("Niepoprawny wybór.");
                }
            } else {
                System.out.println("Nie znaleziono dania o takiej nazwie");
            }
        }
        System.out.println("Zamówione dania: ");
        for (OrderItem item : order.getOrderItems()) {
            System.out.println("- " + item.getDish().getName() + " x " + item.getQuantity() + " = " + item.getDish().getPrice() * item.getQuantity() + "zł");
        }
        System.out.println("Koszt zamówienia: " + order.getTotalPrice() + "zł");
        handlePayment(order);
    }

    // wyswietlenie dań
    private static void displayMenuItems(List<Dishes> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            Dishes item = menuItems.get(i);
            System.out.println((i + 1) + ". " + item.getName() + " - " + item.getPrice() + " zł");
        }
    }

    // obsługa platnosci
    public static void handlePayment(Orders order) {
        while (true) {
            System.out.println("Wybierz sposób płatności:");
            System.out.println("1. Karta");
            System.out.println("2. Gotówka");
            int paymentChoice = getMenuChoice("Wybierz opcję: ", 1, 2);
            PaymentMethod paymentMethod = PaymentMethod.payment(paymentChoice);
            switch (paymentMethod) {
                case CARD:
                    handleCardPayment(order);
                    return;
                case CASH:
                    handleCashPayment(order);
                    return;
                default:
                    System.out.println("Niepoprawny wybór.");
            }
        }
    }

    // platnosc karta
    public static void handleCardPayment(Orders order) {
        while (true) {
            System.out.print("Podaj numer karty (16 cyfr): ");
            String cardNumber = scanner.nextLine();
            try {
                if (cardNumber.length() != 16) {
                    throw new InvalidCardNumberException("Numer karty musi mieć 16 cyfr.");
                }
                boolean isDigit = true;
                for (int i = 0; i < cardNumber.length(); i++) {
                    if (!Character.isDigit(cardNumber.charAt(i))) {
                        isDigit = false;
                        break;
                    }
                }
                if (!isDigit) {
                    throw new InvalidCardNumberException("Numer karty musi mieć tylko cyfry");
                }
                System.out.println("Płatność kartą zakończona pomyślnie! Do widzenia");
                return;
            } catch (InvalidCardNumberException e) {
                System.out.println("Błąd płatności: " + e.getMessage());
            }
        }
    }

    // platnosc gotównka
    public static void handleCashPayment(Orders order) {
        while (true) {
            System.out.print("Podaj kwotę, którą chcesz zapłacić: ");
            double amountPaid = scanner.nextDouble();
            scanner.nextLine();
            try {
                if (amountPaid < 0) {
                    throw new InvalidPaymentAmountException("Kwota nie może być ujemna.");
                }
                if (amountPaid < order.getTotalPrice()) {
                    throw new InvalidPaymentAmountException("Kwota jest za niska. Potrzebujesz zapłacić co najmniej: " + order.getTotalPrice());
                }

                double change = amountPaid - order.getTotalPrice();
                System.out.println("Zapłacono gotówką. Reszta: " + change);
                System.out.println("Płatność gotówką zakończona pomyślnie! Do widzenia.");
                return;
            } catch (InvalidPaymentAmountException e) {
                System.out.println("Błąd płatności: " + e.getMessage());
            }
        }
    }

    // powitanie menadzera i wyswietlenie mu menu menadzera
    public static void handleManagerActions(Restaurant restaurant, ListOfStaff listOfStaff) {
        System.out.println("Witaj, menadżerze!");
        handleManagerMenuNavigation(restaurant, listOfStaff);
    }

    public static void handleManagerMenuNavigation(Restaurant restaurant, ListOfStaff listOfStaff) {
        while (true) {
            String[] options = {"Zarządzanie pracownikami", "Zmiana menu", "Statystyki", "Wyloguj się"};
            displayMenu("Wybierz opcję: ", options);
            int choice = getMenuChoice("Wybierz opcję: ", 1, options.length);
            switch (choice) {
                case 1:
                    handleEmployeeManagement(restaurant, staffManager, listOfStaff);
                    break;
                case 2:
                    handleMenuManagement(restaurant.getMenu(), menuEditor);
                    break;
                case 3:
                    handleStatistics(statisticsManager);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Niepoprawny wybór.");
            }
        }
    }

    // zarzadzanie pracownikami przez menadzera
    public static void handleEmployeeManagement(Restaurant restaurant, StaffManager staffManager, ListOfStaff listOfStaff) {
        while (true) {
            String[] options = {"Odczytanie wszystkich pracowników", "Zwolnienie pracownika", "Dodanie nowego pracownika", "Powrót do poprzedniego menu"};
            displayMenu("Wybierz opcję: ", options);
            int choice = getMenuChoice("Wybierz opcję: ", 1, options.length);
            switch (choice) {
                case 1:
                    System.out.println("Pracownicy restauracji: ");
                    List<Employee> employees = staffManager.getAllEmployees(restaurant);
                    for (Employee employee : employees) {
                        System.out.println("Imię i nazwisko: " + employee.getFirstName() + " " + employee.getLastName() +
                                ", email: " + employee.getEmail() +
                                ", login: " + employee.getCredentials().getLogin() +
                                ", pozycja: " + employee.getPosition());
                    }
                    break;
                case 2:
                    System.out.print("Podaj login pracownika, którego chcesz zwolnić:");
                    String loginToFire = scanner.nextLine();
                    Employee employeeToFire = null;
                    for (Employee employee : restaurant.getEmployees()) {
                        if (employee.getCredentials().getLogin().equalsIgnoreCase(loginToFire)) {
                            employeeToFire = employee;
                            break;
                        }
                    }
                    if (employeeToFire != null) {
                        staffManager.removeEmployee(restaurant, employeeToFire);
                        listOfStaff.removeEmployee(employeeToFire);
                        System.out.println("Pracownik " + employeeToFire.getFirstName() + " " + employeeToFire.getLastName() + " został zwolniony");
                    } else {
                        System.out.println("Nie znaleziono pracownika o takim loginie.");
                    }
                    break;
                case 3:
                    System.out.print("Imię: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Nazwisko: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Login: ");
                    String login = scanner.nextLine();
                    System.out.print("Hasło: ");
                    String password = scanner.nextLine();
                    System.out.print("Stanowisko: ");
                    String position = scanner.nextLine();
                    Credentials newCredentials = new Credentials(login, password);
                    Employee newEmployee = new Employee(firstName, lastName, email, newCredentials, position);
                    staffManager.addEmployee(restaurant, newEmployee);
                    listOfStaff.addEmployee(newEmployee);
                    System.out.println("Dodano nowego pracownika");
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Niepoprawny wybór.");
            }
        }
    }

    // zarzadzanie menu przez menadzera
    public static void handleMenuManagement(Menu menu, MenuEditor menuEditor) {
        while (true) {
            String[] options = {"Dodaj nowe danie", "Usuń danie", "Zmień cenę dania", "Powrót do poprzedniego menu"};
            displayMenu("Wybierz opcję:", options);
            int choice = getMenuChoice("Wybierz opcję:", 1, options.length);
            switch (choice) {
                case 1:
                    System.out.print("Nazwa dania: ");
                    String name = scanner.nextLine();
                    System.out.print("Kategoria: ");
                    String category = scanner.nextLine();
                    System.out.print("Cena: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    Dishes newDish = new Dishes(name, category, price);
                    menuEditor.addDish(menu, newDish);
                    System.out.println("Dodano nowe danie.");
                    break;
                case 2:
                    System.out.println("Podaj nazwę dania, które chcesz usunąć: ");
                    displayMenuItems(menu.getDishes());
                    System.out.print("Nazwa dania: ");
                    String dishName = scanner.nextLine();
                    Dishes dishToRemove = null;
                    for (Dishes dish : menu.getDishes()) {
                        if (dish.getName().equalsIgnoreCase(dishName)) {
                            dishToRemove = dish;
                            break;
                        }
                    }
                    if (dishToRemove != null) {
                        menuEditor.removeDish(menu, dishToRemove);
                        System.out.println("Usunięto danie " + dishToRemove.getName());
                    } else {
                        System.out.println("Nie znaleziono dania o takiej nazwie.");
                    }
                    break;
                case 3:
                    System.out.println("Podaj nazwę dania, którego cenę chcesz zmienić:");
                    displayMenuItems(menu.getDishes());
                    System.out.print("Nazwa dania: ");
                    String menuItemNameToChangePrice = scanner.nextLine();
                    Dishes menuItemToChange = null;
                    for (Dishes dish : menu.getDishes()) {
                        if (dish.getName().equalsIgnoreCase(menuItemNameToChangePrice)) {
                            menuItemToChange = dish;
                            break;
                        }
                    }
                    if (menuItemToChange != null) {
                        System.out.print("Podaj nową cenę:");
                        double newPrice = scanner.nextDouble();
                        scanner.nextLine();
                        menuEditor.updateDishPrice(menu, menuItemToChange.getName(), newPrice);
                        System.out.println("Cena dania " + menuItemToChange.getName() + " zmieniona na " + newPrice);
                    } else {
                        System.out.println("Nie znaleziono dania o takiej nazwie");
                    }
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Niepoprawny wybor.");
            }
        }
    }

    // zarzadzanie statystykami przez menadzera
    public static void handleStatistics(StatisticsManager statisticsManager) {
        while (true) {
            String[] options = {"Dodawanie godzin największego ruchu", "Odczyt godzin największego ruchu", "Powrót do poprzedniego menu"};
            displayMenu("Wybierz opcję: ", options);
            int choice = getMenuChoice("Wybierz opcję: ", 1, options.length);
            switch (choice) {
                case 1:
                    System.out.println("Podaj godzinę największego ruchu:");
                    String peakHour = scanner.nextLine();
                    statisticsManager.addPeakHour(peakHour);
                    System.out.println("Dodano godzinę największego ruchu.");
                    break;
                case 2:
                    System.out.println("Godziny największego ruchu:");
                    for (String hour : statisticsManager.getPeakHours()) {
                        System.out.println("- " + hour);
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Niepoprawny wybór.");
            }
        }
    }
}