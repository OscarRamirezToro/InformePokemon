package org.ejemplo.pokemon.service;

import org.ejemplo.pokemon.model.EstadisticasPokemon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class InformeService {

    public void generarInforme(EstadisticasPokemon stats, Path rutaSalida) throws IOException {
        StringBuilder sb = new StringBuilder();

        sb.append("=========================\n");
        sb.append(" INFORME DE POKÉMON\n");
        sb.append("=========================\n\n");

        sb.append(String.format(Locale.US, "Total de Pokémon: %d\n\n", stats.getTotal()));
        sb.append(String.format(Locale.US, "Nivel medio: %.2f\n\n", stats.getNivelMedio()));
        sb.append(String.format(Locale.US, "PS medios: %.2f\n\n", stats.getPsMedio()));

        if (stats.getMaxNivel() != null) {
            sb.append("Pokémon con mayor nivel:\n");
            sb.append(String.format("%s (Nivel %d)\n\n", stats.getMaxNivel().getNombre(), stats.getMaxNivel().getNivel()));
        }

        if (stats.getMaxPs() != null) {
            sb.append("Pokémon con más PS:\n");
            sb.append(String.format("%s (PS %d)\n\n", stats.getMaxPs().getNombre(), stats.getMaxPs().getPs()));
        }

        sb.append("-------------------------\n");
        sb.append("POKÉMON POR TIPO\n");
        sb.append("-------------------------\n\n");

        for (Map.Entry<String, Long> entry : stats.getCantidadPorTipo().entrySet()) {
            String tipo = entry.getKey();
            Long cantidad = entry.getValue();
            sb.append(String.format("%s: %d\n", tipo, cantidad));

            List<String> nombres = stats.getNombresPorTipo().get(tipo);
            if (nombres != null) {
                for (String nombre : nombres) {
                    sb.append(nombre).append("\n");
                }
            }
            sb.append("\n");
        }

        try (BufferedWriter writer = Files.newBufferedWriter(rutaSalida)) {
            writer.write(sb.toString().trim());
            writer.newLine();
        }
    }
}