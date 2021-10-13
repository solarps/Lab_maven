package Lab1;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        for (int i = 0; i < 10; i++) {
            Products.list.add(Product.setProduct());
            System.out.println(Products.list.get(i));
        }
        System.out.println("--------------------------");
        Products.getLowAveragePriceProduct();
        Serialization.save("Save.txt");
        Serialization.load("Save.txt");
        System.out.println("\n--------------------------Native Serialization--------------------------\n");
        for (int i = 0; i < Products.list.size(); i++) {
            System.out.println(Products.list.get(i));
        }
        SerializationToCSV.save("Save.csv");
        SerializationToCSV.load("Save.csv");
        System.out.println("\n--------------------------Serialization to CSV--------------------------\n");
        for (int i = 0; i < Products.list.size(); i++) {
            System.out.println(Products.list.get(i));
        }
        SerializationToJSON.save("Save.json");
        SerializationToJSON.load("Save.json");
        System.out.println("\n--------------------------Serialization to JSON--------------------------\n");
        for (int i = 0; i < Products.list.size(); i++) {
            System.out.println(Products.list.get(i));
        }
    }
}
