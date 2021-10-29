package Lab4;

public class LoadThread extends Thread{
    static APIData data;
    @Override
    public void run(){
        APIGetter apiGetter = DownloadThread.apiGetter;
        data = (APIData) apiGetter.JsonParse(1);
    }
}