package Lab4;

import java.util.Comparator;
import java.util.Random;

public class Main {
    static Random random = new Random();

    public static void main(String[] args) {
        Thread downloadThread = new DownloadThread();
        downloadThread.start();
        try {
            downloadThread.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
        APIData data = DownloadThread.data;
        System.out.println(data);
        System.out.println("Sorted by name:");
        data.getData().sort(Comparator.comparing(Anime::getAnimeName));
        System.out.println(data);
        int i = random.nextInt(data.getData().size());
        String Anime_name = data.getData().get(i).getAnimeName();
        APIGetter apiGetter = new APIGetter();
        APIGetter.url = "https://anime-facts-rest-api.herokuapp.com/api/v1/" + Anime_name;
        apiGetter.run();
        Facts facts = (Facts) apiGetter.JsonParse(Facts.class);
        System.out.println("Anime: " + Anime_name);
        System.out.println(facts);
    }
}
