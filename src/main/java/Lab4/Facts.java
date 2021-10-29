package Lab4;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Facts {

    private boolean success;
    private String img;
    private int totalFacts;
    private List<Fact> data = null;

    public Facts() {
    }

    public Facts(boolean success, String img, int totalFacts, List<Fact> data) {
        super();
        this.success = success;
        this.img = img;
        this.totalFacts = totalFacts;
        this.data = data;
    }

    @JsonGetter("total_facts")
    public int getTotalFacts() {
        return totalFacts;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Facts{");
        sb.append("img='").append(img).append('\'').append("\n");
        sb.append("totalFacts=").append(totalFacts).append("\n");
        sb.append("Facts=").append(data);
        sb.append('}');
        return sb.toString();
    }
}