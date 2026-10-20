package org.ejemplo.pokemon.repository;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.ejemplo.pokemon.model.Pokemon;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PokemonJsonRepository implements PokemonRepository {
    private final Path rutaFichero;
    private final Gson gson;

    public PokemonJsonRepository(Path rutaFichero) {
        this.rutaFichero = rutaFichero;
        this.gson = new Gson();
    }

    @Override
    public List<Pokemon> cargarPokemons() throws IOException {
        if (!Files.exists(rutaFichero)) {
            throw new IOException("El archivo JSON no existe en: " + rutaFichero);
        }

        try (Reader reader = Files.newBufferedReader(rutaFichero)) {
            Type listType = new TypeToken<ArrayList<Pokemon>>() {}.getType();
            List<Pokemon> lista = gson.fromJson(reader, listType);
            return lista != null ? lista : new ArrayList<>();
        }
    }
}