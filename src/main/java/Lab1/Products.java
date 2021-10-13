package Lab1;

import java.util.ArrayList;
import java.util.List;

public class Products {
    static List<Product> list = new ArrayList<>();

    public static List<Product> getLowAveragePriceProduct() {
        double average = 0;
        for (Product product : list) {
            average += product.getPrice();
        }
        average = average / list.size();
        System.out.println(average);
        List<Product> newProductsList = new ArrayList<>();
        for (Product product : list) {
            if (product.getPrice() < average) {
                newProductsList.add(product);
                System.out.println(product);
            }
        }
        return list = newProductsList;
    }


}
