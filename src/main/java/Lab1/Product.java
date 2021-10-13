package Lab1;

import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Random;
import java.util.StringJoiner;

@Getter
public class Product implements Serializable {
    private ProductType name;
    private int count;
    private double price;
    private Creators creator;
    private LocalDate date;


    public Product(ProductType name, int count, double price, Creators creator, LocalDate date) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.creator = creator;
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public static Product setProduct(){
        Random random = new Random();
        int day = random.nextInt(30)+1;
        int month = random.nextInt(11)+1;
        int year = random.nextInt(21) + 2000;
        int count = random.nextInt(200);
        int price = random.nextInt(5) * 100 + 99;
        return new Product(ProductType.getType(random.nextInt(4)), count, price, Creators.getCreator(random.nextInt(4)), LocalDate.of(year,month,day));
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("count=" + count)
                .add("price=" + price)
                .add("creator='" + creator + "'")
                .add("date=" + date)
                .toString();
    }

}
