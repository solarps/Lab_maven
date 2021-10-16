package Lab1;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class SerializationToCSV extends Products{

    public static void save(String filename) throws IOException {
        FileWriter outStream = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(outStream);
        bw.write("Type;Count;Price;Manufacturer;Date;");
        bw.write(System.lineSeparator());
        for (Product product : list) {
            try {
                bw.write(product.getName() + ";");
                bw.write(product.getCount() + ";");
                bw.write(product.getPrice() + ";");
                bw.write(product.getCreator() + ";");
                bw.write(product.getDate() + ";");
                bw.write(System.lineSeparator());
            } catch (IOException e) {
                System.out.println("Ошибка записи: "+ e);
            }
        }
        bw.close();
        outStream.close();
    }

    public static void load(String filename) throws IOException {
        Products.list.clear();
        Scanner scanner = new Scanner(new FileReader(filename));
        String str;
        scanner.nextLine();
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            String[] strings = str.split(";");
            list.add(new Product(ProductType.valueOf(strings[0]),Integer.parseInt(strings[1]),
                    Double.parseDouble(strings[2]),Creators.valueOf(strings[3]),LocalDate.parse(strings[4])));
        }
        scanner.close();
    }
}
