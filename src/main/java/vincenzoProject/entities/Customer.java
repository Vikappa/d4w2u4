package vincenzoProject.entities;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Random;

public class Customer {
    long id;
    String name;
    Integer tier;

    public Customer(long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
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

    public Integer getTier() {
        return tier;
    }

    public void setTier(Integer tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }

    public static Customer genereteRandomCustomer() {
        Faker faker = new Faker(Locale.ITALIAN);
        String newName = faker.name().firstName();
        int newTier = faker.number().numberBetween(1, 3);
        Random random = new Random();
        long newId = random.nextLong();
        return new Customer(newId, newName, newTier);
}

}
