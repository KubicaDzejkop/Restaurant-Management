package pl.gornik.menu;

public class Dishes {
    private String name;
    private String category;
    private double price;
    public Dishes(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
