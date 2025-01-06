package pl.gornik.klient;

public enum PaymentMethod {
    CARD("Karta"),
    CASH("Gotówka");

    private String displayName;

    PaymentMethod(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
    public static PaymentMethod payment(int choice){
        if (choice == 1){
            return CARD;
        } else if (choice == 2){
            return CASH;
        }
        return null;
    }
}