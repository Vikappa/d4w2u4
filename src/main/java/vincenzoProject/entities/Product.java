package vincenzoProject.entities;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class Product {
    long id;
    String name;
    String category;
    double price;

    public Product(long id, String name, String category, double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }

    public static Product generateRandomProduct(){
        Faker faker = new Faker(Locale.ITALIAN);
        Random rand = new Random();

        long id = Math.abs(rand.nextLong());
        String name = faker.commerce().productName();
        String category = faker.commerce().department();
        double price = Math.round(rand.nextDouble() * 10000.0) / 100.0;
        return new Product(id, name, category, price);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
