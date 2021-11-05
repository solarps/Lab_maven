package Lab4;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class APIData {
    private boolean success;
    private List<Anime> data = null;

    public APIData() {
    }

    public APIData(boolean success, List<Anime> data) {
        super();
        this.success = success;
        this.data = data;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("APIData{");
        sb.append("data=").append(data);
        sb.append('}');
        return sb.toString();
    }

   /* public void sortByName(){
        for (Anime anime : data){
            anime.compareTo()
        }
    }*/
}