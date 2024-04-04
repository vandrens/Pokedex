package pokedex.integrations.dto;

import java.util.List;

public class PokemonDTO {

    private String name;

    private String url;

    private PokemonSpritesDTO sprites;
    private Object abilities;

    private Integer base_experience;

    private List<PokemonTypesDTO> types;

    private Integer weight;

    private List<PokemonMovesDTO> moves;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PokemonSpritesDTO getSprites() {
        return sprites;
    }

    public void setSprites(PokemonSpritesDTO sprites) {
        this.sprites = sprites;
    }

    public Object getAbilities() {
        return abilities;
    }

    public void setAbilities(Object abilities) {
        this.abilities = abilities;
    }

    public Integer getBase_experience() {
        return base_experience;
    }

    public void setBase_experience(Integer base_experience) {
        this.base_experience = base_experience;
    }

    public List<PokemonTypesDTO> getTypes() {
        return types;
    }

    public void setTypes(List<PokemonTypesDTO> types) {
        this.types = types;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public List<PokemonMovesDTO> getMoves() {
        return moves;
    }

    public void setMoves(List<PokemonMovesDTO> moves) {
        this.moves = moves;
    }
}
