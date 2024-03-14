package vincenzoProject.entities;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.github.javafaker.Faker;

public class Order {
    long id;
    String status;
    LocalDate orderDate;
    LocalDate deliveryDate;
    ArrayList<Product> products;
    Customer customer;

    public Order(long id, String status, LocalDate orderDate, LocalDate deliveryDate, ArrayList<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public static Order generateRandomOrder() {
        Random rand = new Random();
        Faker faker = new Faker();

        long id = Math.abs(rand.nextLong());
        String status = faker.options().option("Pending", "Shipped", "Delivered");
        LocalDate orderDate = faker.date().past(10, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate deliveryDate = orderDate.plusDays(rand.nextInt(9) + 1);
        ArrayList<Product> products = new ArrayList<>();
        int nElementi = rand.nextInt(10) + 1;

        for (int i = 0; i < nElementi; i++) {
            products.add(Product.generateRandomProduct());
        }

        Customer customer = Customer.genereteRandomCustomer();

        return new Order(id, status, orderDate, deliveryDate, products, customer);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderDate=" + orderDate +
                ", deliveryDate=" + deliveryDate +
                ", products=" + products +
                ", customer=" + customer +
                '}';
    }
}
