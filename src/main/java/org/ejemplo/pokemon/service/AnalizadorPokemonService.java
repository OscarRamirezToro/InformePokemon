package org.ejemplo.pokemon.service;

import org.ejemplo.pokemon.model.EstadisticasPokemon;
import org.ejemplo.pokemon.model.Pokemon;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnalizadorPokemonService {

    public EstadisticasPokemon calcularEstadisticas(List<Pokemon> pokemons) {
        if (pokemons == null || pokemons.isEmpty()) {
            throw new IllegalArgumentException("La lista de Pokémon no puede estar vacía.");
        }

        int total = pokemons.size();

        double nivelMedio = pokemons.stream()
                .mapToInt(Pokemon::getNivel)
                .average()
                .orElse(0.0);

        double psMedio = pokemons.stream()
                .mapToInt(Pokemon::getPs)
                .average()
                .orElse(0.0);

        Pokemon maxNivel = pokemons.stream()
                .max(Comparator.comparingInt(Pokemon::getNivel))
                .orElse(null);

        Pokemon maxPs = pokemons.stream()
                .max(Comparator.comparingInt(Pokemon::getPs))
                .orElse(null);

        Map<String, Long> cantidadPorTipo = pokemons.stream()
                .collect(Collectors.groupingBy(Pokemon::getTipo, Collectors.counting()));

        Map<String, List<String>> nombresPorTipo = pokemons.stream()
                .collect(Collectors.groupingBy(
                        Pokemon::getTipo,
                        Collectors.mapping(Pokemon::getNombre, Collectors.toList())
                ));

        return new EstadisticasPokemon(total, nivelMedio, psMedio, maxNivel, maxPs, cantidadPorTipo, nombresPorTipo);
    }
}