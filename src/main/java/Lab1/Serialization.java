package Lab1;

import java.io.*;
import java.util.ArrayList;


public class Serialization extends Products {

    public static void save(String filename) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(list);
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e);
        }

    }

    public static void load(String filename) {
        Products.list.clear();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))) {
            list=((ArrayList<Product>)objectInputStream.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
