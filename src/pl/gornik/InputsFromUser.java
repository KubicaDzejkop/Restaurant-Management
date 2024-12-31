package pl.gornik;

import java.util.Scanner;

public class InputsFromUser {
    private static Scanner scanner = new Scanner(System.in);

    // pobieranie lancucha znakow od uzytkownika
    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    // pobieranie wartości liczbowej od uzytkownika
    public static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Niepoprawna wartość. Podaj liczbę całkowitą.");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

    // pobieranie wartosci zmiennoprzecinkowej od uzytkownika
    public static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("Niepoprawna wartość. Podaj liczbę.");
            scanner.next();
        }
        double input = scanner.nextDouble();
        scanner.nextLine();
        return input;
    }
}
