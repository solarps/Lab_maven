package Lab4;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class APIData {
    private boolean success;
    private List<Datum> data = null;

    public APIData() {
    }

    public APIData(boolean success, List<Datum> data) {
        super();
        this.success = success;
        this.data = data;
    }
}