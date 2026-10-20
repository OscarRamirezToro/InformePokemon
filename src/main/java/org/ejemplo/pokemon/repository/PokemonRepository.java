package org.ejemplo.pokemon.repository;

import org.ejemplo.pokemon.model.Pokemon;
import java.io.IOException;
import java.util.List;

public interface PokemonRepository {
    List<Pokemon> cargarPokemons() throws IOException;
}