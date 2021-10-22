package Lab1;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("If you want to load db from file enter 1 else enter 0");
        int a = scanner.nextInt();
        switch (a){
            case 0:
                for (int i = 0; i < 10; i++) {
                    Products.list.add(Product.setProduct());
                    System.out.println(Products.list.get(i));
                    System.out.println("--------------------------");
                    Products.getLowAveragePriceProduct();
                }
                break;
            case 1:
                Serialization.load("Save.txt");
                SerializationToCSV.load("Save.csv");
                SerializationToJSON.load("Save.json");
                SerializationToFASTJSON.load("FASTSave.json");
                break;
            default:
                System.out.println("Wrong number");
                System.exit(0);
        }

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
        SerializationToFASTJSON.save("FASTSave.json");
        SerializationToFASTJSON.load("FASTSave.json");
        System.out.println("\n--------------------------Serialization to FASTJSON--------------------------\n");
        for (int i = 0; i < Products.list.size(); i++) {
            System.out.println(Products.list.get(i));
        }
    }
}
