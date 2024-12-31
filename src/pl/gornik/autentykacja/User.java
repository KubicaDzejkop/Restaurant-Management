package pl.gornik.autentykacja;

public abstract class User {
    private Credentials credentials;
    private String email;

    public User(Credentials credentials, String email) {
        this.credentials = credentials;
        this.email = email;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public String getEmail() {
        return email;
    }

    // to jest typ uzytkownika, dzieki ktoremu bede sie poslugiwal nazewnictwem np. klienta lub menadzera
    public abstract String getUserType();
}
