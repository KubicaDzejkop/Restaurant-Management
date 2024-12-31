package pl.gornik.klient;

public class InvalidPaymentAmountException extends Exception {
    public InvalidPaymentAmountException(String message) {
        super(message);
    }
}
