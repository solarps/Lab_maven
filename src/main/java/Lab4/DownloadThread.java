package Lab4;

public class DownloadThread extends Thread{
    static APIData data;
    @Override
    public void run(){
        APIGetter apiGetter = new APIGetter();
        APIGetter.url = "https://anime-facts-rest-api.herokuapp.com/api/v1";
        apiGetter.ConnectAndGetData();
        data = (APIData) apiGetter.JsonParse(APIData.class);
    }
}
