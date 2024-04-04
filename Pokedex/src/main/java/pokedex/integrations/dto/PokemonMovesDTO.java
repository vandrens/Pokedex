package pokedex.integrations.dto;

import java.util.List;

public class PokemonMovesDTO {

    private MoveDTO move;

    public MoveDTO getMoves() {
        return move;
    }

    public void setMoves(MoveDTO move) {
        this.move = move;
    }
}
