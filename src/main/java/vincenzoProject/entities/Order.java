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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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
