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

    public abstract String getUserType();
}
