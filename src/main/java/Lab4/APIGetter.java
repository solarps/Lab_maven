package Lab4;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class APIGetter implements Runnable{
    public String jsonIn;
    public static String url;

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public String ConnectAndGetData() {
        jsonIn = "";
        InputStream is = null;
        try {
            is = new URL(url).openStream();
            try {
                BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
                try {
                    jsonIn = readAll(rd);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } finally {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonIn;
    }

    public Object JsonParse(int type) {
        ObjectMapper mapper = new ObjectMapper();
        Object data = null;
        try {
            if (type == 1) {
                data = mapper.readValue(jsonIn, APIData.class);
            }
            if (type == 2) {
                data = mapper.readValue(jsonIn, Facts.class);
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return data;
    }

    @Override
    public void run() {
        ConnectAndGetData();
    }
}
