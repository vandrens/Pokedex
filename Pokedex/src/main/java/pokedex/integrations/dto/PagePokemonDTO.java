package pokedex.integrations.dto;

import java.util.List;

public class PagePokemonDTO {

    private List<PokemonDTO> results;

    private Integer count;

    private String next;

    private String previous;

    private Integer size;

    public List<PokemonDTO> getResults() {
        return results;
    }

    public void setResults(List<PokemonDTO> results) {
        this.results = results;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
