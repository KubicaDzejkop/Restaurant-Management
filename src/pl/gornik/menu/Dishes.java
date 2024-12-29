package pl.gornik.menu;

public class Dishes {
    private String name;
    private String category;
    private double price;
    private String subCategory;

    public Dishes(String name, String category, double price, String subCategory) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
