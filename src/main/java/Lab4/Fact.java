package Lab4;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Fact {
    private int factId;
    private String fact;

    public Fact() {
    }

    public Fact(int factId, String fact) {
        super();
        this.factId = factId;
        this.fact = fact;
    }

    @JsonGetter("fact_id")
    public int getFactId() {
        return factId;
    }

    @JsonGetter("fact")
    public String getFact() {
        return fact;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("factId=").append(factId).append(",");
        sb.append("fact='").append(fact).append("'\n");
        return sb.toString();
    }
}