package org.ejemplo.pokemon.model;

import java.util.List;
import java.util.Map;

public class EstadisticasPokemon {
    private final int total;
    private final double nivelMedio;
    private final double psMedio;
    private final Pokemon maxNivel;
    private final Pokemon maxPs;
    private final Map<String, Long> cantidadPorTipo;
    private final Map<String, List<String>> nombresPorTipo;

    public EstadisticasPokemon(int total, double nivelMedio, double psMedio, Pokemon maxNivel, Pokemon maxPs, Map<String, Long> cantidadPorTipo, Map<String, List<String>> nombresPorTipo) {
        this.total = total;
        this.nivelMedio = nivelMedio;
        this.psMedio = psMedio;
        this.maxNivel = maxNivel;
        this.maxPs = maxPs;
        this.cantidadPorTipo = cantidadPorTipo;
        this.nombresPorTipo = nombresPorTipo;
    }

    public int getTotal() {
        return total;
    }

    public double getNivelMedio() {
        return nivelMedio;
    }

    public double getPsMedio() {
        return psMedio;
    }

    public Pokemon getMaxNivel() {
        return maxNivel;
    }

    public Pokemon getMaxPs() {
        return maxPs;
    }

    public Map<String, Long> getCantidadPorTipo() {
        return cantidadPorTipo;
    }

    public Map<String, List<String>> getNombresPorTipo() {
        return nombresPorTipo;
    }
}