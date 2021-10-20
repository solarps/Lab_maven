package Lab1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class SerializationToJSON extends Products{
    @JsonProperty("wrapper")
    public static void save(String filename)throws IOException {
        new ObjectMapper().registerModule(new JavaTimeModule()).writeValue(new File(filename), list);
    }

    public static void load(String filename) throws IOException {
        list.clear();
        byte[] Data = Files.readAllBytes(Paths.get(filename));
        List<LinkedHashMap<String,?>> newList = new ObjectMapper().readValue(Data, List.class);
        List<Integer> arrDate;
        ProductType name;
        Creators creators;
        LocalDate date;
        int count,year,month,day;
        double price;
        for (LinkedHashMap<String,?> obj: newList){
            name = ProductType.valueOf((String) obj.get("name"));
            count = (int) obj.get("count");
            price = (double) obj.get("price");
            creators = Creators.valueOf((String)obj.get("creator"));
            arrDate = (List<Integer>) obj.get("date");
            year = arrDate.get(0);
            month = arrDate.get(1);
            day = arrDate.get(2);
            date = LocalDate.of(year,month,day);
            list.add(new Product(name,count,price,creators,date));
        }
    }
}
