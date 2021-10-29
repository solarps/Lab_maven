package Lab4;

public class DownloadThread extends Thread{
    static APIGetter apiGetter = new APIGetter();
    @Override
    public void run(){
        APIGetter.url = "https://anime-facts-rest-api.herokuapp.com/api/v1";
        apiGetter.ConnectAndGetData();
    }
}
