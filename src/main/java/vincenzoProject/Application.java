package vincenzoProject;

import vincenzoProject.entities.Customer;
import vincenzoProject.entities.Order;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        Logger logger = new Logger();

        ArrayList<Order> orders = new ArrayList<>();

        //CREO 30 ORDINI PER AVERE DEI CASI ESEMPIO UTILI
        for (int i = 0; i < 30; i++) {
            orders.add(Order.generateRandomOrder());
        }

        logger.info("ORDINI GENERATI");


    }
}
