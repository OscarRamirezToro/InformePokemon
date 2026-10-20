package org.ejemplo.pokemon;

import org.ejemplo.pokemon.model.EstadisticasPokemon;
import org.ejemplo.pokemon.model.Pokemon;
import org.ejemplo.pokemon.repository.PokemonJsonRepository;
import org.ejemplo.pokemon.repository.PokemonRepository;
import org.ejemplo.pokemon.service.AnalizadorPokemonService;
import org.ejemplo.pokemon.service.InformeService;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path rutaEntrada = Paths.get("pokemon.json");
        Path rutaSalida = Paths.get("informe_pokemon.txt");

        PokemonRepository repository = new PokemonJsonRepository(rutaEntrada);
        AnalizadorPokemonService analizadorService = new AnalizadorPokemonService();
        InformeService informeService = new InformeService();

        try {
            List<Pokemon> pokemons = repository.cargarPokemons();
            EstadisticasPokemon estadisticas = analizadorService.calcularEstadisticas(pokemons);
            informeService.generarInforme(estadisticas, rutaSalida);
        } catch (IOException e) {
            System.err.println("Error de E/S durante la ejecución: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error en los datos analizados: " + e.getMessage());
        }
    }
}