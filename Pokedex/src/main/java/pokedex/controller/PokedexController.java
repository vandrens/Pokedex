package pokedex.controller;

import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;
import pokedex.integration.PokedexIntegration;
import pokedex.integrations.dto.PokemonDTO;
import pokedex.integrations.dto.PokemonMovesDTO;
import pokedex.integrations.dto.PokemonTypesDTO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


public class PokedexController implements Initializable {

    @FXML
    public ListView<PokemonDTO> pokemonListView;
    @FXML
    public ListView movesListView = new ListView();
    @FXML
    public ListView typeListView = new ListView();
    @FXML
    public ImageView pokemonImageView;
    @FXML
    public TextArea descriptionTextArea;



    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            PokedexIntegration pokedexIntegration = new PokedexIntegration();
            List<PokemonDTO> pokemonDTOList = pokedexIntegration.listPokemons();
            pokemonListView.setItems(FXCollections.observableList(pokemonDTOList));

            pokemonListView.setCellFactory(lv -> {
                TextFieldListCell<PokemonDTO> cell = new TextFieldListCell<PokemonDTO>();
                cell.setConverter(new StringConverter<PokemonDTO>() {
                    @Override
                    public String toString(PokemonDTO pokemon) {
                        return formatNamePokemon(pokemon);
                    }
                    @Override
                    public PokemonDTO fromString(String string) {
                        PokemonDTO person = cell.getItem();
                        person.setName(string);
                        return person ;
                    }
                });
                return cell;
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String formatNamePokemon(final PokemonDTO pokemon){
        return pokemon.getUrl().split("/")[6] + " - " + pokemon.getName();
    }

    public void onClickPokemon(Event event){
        try {

            PokedexIntegration pokedexIntegration = new PokedexIntegration();
            final PokemonDTO pokemon = pokemonListView.getSelectionModel().getSelectedItem();
            final PokemonDTO pokemonDetail =  pokedexIntegration.getPokemon(pokemon.getUrl());


            Image image = new Image(pokemonDetail.getSprites().getFront_default());
            pokemonImageView.setImage(image);

            typeListView.setItems(FXCollections.observableList(pokemonDetail.getTypes()));
            typeListView.setCellFactory(lv -> {
                TextFieldListCell<PokemonTypesDTO> cell = new TextFieldListCell<PokemonTypesDTO>();
                cell.setConverter(new StringConverter<PokemonTypesDTO>() {
                    @Override
                    public String toString(PokemonTypesDTO person) {
                        return person.getType().getName();
                    }
                    @Override
                    public PokemonTypesDTO fromString(String string) {
                        PokemonTypesDTO person = cell.getItem();
                        person.getType().setName(string);
                        return person ;
                    }
                });
                return cell;
            });

            movesListView.setItems(FXCollections.observableList(pokemonDetail.getMoves()));
            movesListView.setCellFactory(lv -> {
                TextFieldListCell<PokemonMovesDTO> cell = new TextFieldListCell<PokemonMovesDTO>();
                cell.setConverter(new StringConverter<PokemonMovesDTO>() {
                    @Override
                    public String toString(PokemonMovesDTO person) {
                        return person.getMoves().getName();
                    }
                    @Override
                    public PokemonMovesDTO fromString(String string) {
                        PokemonMovesDTO person = cell.getItem();
                        person.getMoves().setName(string);
                        return person ;
                    }
                });
                return cell;
            });
            descriptionTextArea.setText("Pokemon");


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
