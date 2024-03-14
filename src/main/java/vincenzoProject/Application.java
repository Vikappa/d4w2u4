package vincenzoProject;

import vincenzoProject.entities.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vincenzoProject.entities.Product;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Application {

    static Scanner scanner = new Scanner(System.in);
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    private static ArrayList<Order> searchOrdinePerCliente(ArrayList<Order> listaIniziale, String searchName) {
        ArrayList<Order> ordini = new ArrayList<>();
        listaIniziale.stream().filter(o -> o.getCustomer().getName().equals(searchName)).forEach(ordini::add);
        return ordini;
    }

    public static void main(String[] args) {
        ArrayList<Order> orders = new ArrayList<>();

        // CREO 300 ORDINI PER AVERE DEI CASI ESEMPIO UTILI
        for (int i = 0; i < 300; i++) {
            orders.add(Order.generateRandomOrder());
        }
        logger.info("----------------------------- Ordini generati: ---------------------------------------");

        // ANTEPRIMA DELLA LISTA PER CONFRONTI
        orders.forEach(order -> logger.info(order.toString()));

        logger.info("\n----------------------------- ESERCIZIO 1: ---------------------------------------");
        String searchName;
        do {
            logger.info("Digita il nome del cliente per cui vuoi cercare gli ordini: ");
            searchName = scanner.nextLine();
        } while (searchName.trim().isEmpty());

        logger.info("-------------------------- NOME CERCATO: " + searchName);
        ArrayList<Order> ordiniDelCliente = searchOrdinePerCliente(orders, searchName);

        logger.info("----------------------------- ESERCIZIO 2: ---------------------------------------");
        logger.info("-----------Cerco gli ordini di " + searchName + "e calcolo la spesa totale con una mappa" );

        double spesaTotale = ordiniDelCliente.stream()
                .flatMap(order -> order.getProducts().stream())
                .mapToDouble(product -> product.getPrice())
                .sum();

        ordiniDelCliente.stream().forEach(order -> order.getProducts().stream().forEach(product -> logger.info( "{"+ product.toString()+"}")));
        logger.info("Spesa totale: " + spesaTotale);
        logger.info("----------------------------- ESERCIZIO 3: ---------------------------------------");
        logger.info("------------------TRASFORMO LA LISTA DI ORDINI DI PARTENZA IN UNA LISTA DI PRODOTTI");


        logger.info("------------------USO .max() per trovare il prodotto con il prezzo più alto di tutto il magazzino");

    }
}
