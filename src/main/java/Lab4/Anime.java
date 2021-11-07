package Lab4;

import com.fasterxml.jackson.annotation.JsonGetter;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Anime {

    private int animeId;
    private String animeName;
    private String animeImg;

    public Anime() {
    }

    public Anime(int animeId, String animeName, String animeImg) {
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("\nAnime{");
        sb.append("animeId=").append(animeId);
        sb.append(", animeName='").append(animeName).append('\'');
        sb.append(", animeImg='").append(animeImg).append('\'');
        sb.append('}');
        return sb.toString();
    }
}