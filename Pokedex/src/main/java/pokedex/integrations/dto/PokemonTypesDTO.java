package pokedex.integrations.dto;

public class PokemonTypesDTO {

    private int slot;
    private TypeDTO type;

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public TypeDTO getType() {
        return type;
    }

    public void setType(TypeDTO type) {
        this.type = type;
    }
}
