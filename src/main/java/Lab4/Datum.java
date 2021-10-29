package Lab4;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Datum {

    private int animeId;
    private String animeName;
    private String animeImg;

    public Datum() {
    }

    public Datum(int animeId, String animeName, String animeImg) {
        super();
        this.animeId = animeId;
        this.animeName = animeName;
        this.animeImg = animeImg;
    }

    @JsonGetter("anime_id")
    public int getAnimeId() {
        return animeId;
    }
    @JsonGetter("anime_name")
    public String getAnimeName() {
        return animeName;
    }
    @JsonGetter("anime_img")
    public String getAnimeImg() {
        return animeImg;
    }
}