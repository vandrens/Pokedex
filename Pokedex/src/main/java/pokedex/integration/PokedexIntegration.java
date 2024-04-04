package pokedex.integration;

import com.google.gson.GsonBuilder;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import pokedex.integrations.dto.PagePokemonDTO;
import pokedex.integrations.dto.PokemonDTO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PokedexIntegration {

    private static final String URL_API = "https://pokeapi.co/api/v2/pokemon?offset=0&limit=60";
    public List<PokemonDTO> listPokemons() throws IOException {

        List<PokemonDTO> pokemonDTOList = new ArrayList<>();
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(URL_API);

        CloseableHttpResponse response = httpClient.execute(httpGet);

        try {
            final String responseBody = EntityUtils.toString(response.getEntity());

            final PagePokemonDTO pagePokemon = new GsonBuilder().create().fromJson(responseBody, PagePokemonDTO.class);
            pokemonDTOList = pagePokemon.getResults();
        } finally {
            response.close();
        }

        httpClient.close();

        return pokemonDTOList;
    }

    public PokemonDTO getPokemon(final String urlPokmon) throws IOException {

        PokemonDTO pokemonDTO = null;
        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpGet = new HttpGet(urlPokmon);

        CloseableHttpResponse response = httpClient.execute(httpGet);

        try {
            final String responseBody = EntityUtils.toString(response.getEntity());

            pokemonDTO = new GsonBuilder().create().fromJson(responseBody, PokemonDTO.class);
        } finally {
            response.close();
        }

        httpClient.close();

        return pokemonDTO;
    }

}
