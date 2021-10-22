package Lab1;

import com.alibaba.fastjson.JSON;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SerializationToFASTJSON extends Products{

    public static void save (String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write(JSON.toJSONString(list, true));
        } catch (IOException exception) {
            System.out.println("Ошибка записи" + exception);
        }
    }

    public static void load(String filename) {
        list.clear();
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            String content = lines.collect(Collectors.joining());
            list = JSON.parseArray(content, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
