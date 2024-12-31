package pl.gornik.klient;

public class InvalidCardNumberException extends Exception {
    public InvalidCardNumberException(String message) {
        super(message);
    }
}
