package Lab1;

import com.alibaba.fastjson.JSON;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SerializationToJSON extends Products{

    public static void save (String filename) throws IOException {
        FileWriter outStream = new FileWriter(filename);
        BufferedWriter bw = new BufferedWriter(outStream);
        bw.write(JSON.toJSONString(list, true));
        bw.close();
        outStream.close();
    }

    public static void load(String filename) {
        Products.list.clear();
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            String content = lines.collect(Collectors.joining());
            Products.list = JSON.parseArray(content, Product.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
