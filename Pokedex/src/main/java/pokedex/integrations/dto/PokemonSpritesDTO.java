package pokedex.integrations.dto;

public class PokemonSpritesDTO {

    private String back_default;

    private String front_default;

    private PokemonSpritesOtherDTO other;

    public String getBack_default() {
        return back_default;
    }

    public void setBack_default(String back_default) {
        this.back_default = back_default;
    }

    public String getFront_default() {
        return front_default;
    }

    public void setFront_default(String front_default) {
        this.front_default = front_default;
    }

    public PokemonSpritesOtherDTO getOther() {
        return other;
    }

    public void setOther(PokemonSpritesOtherDTO other) {
        this.other = other;
    }
}
