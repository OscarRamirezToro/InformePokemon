package org.ejemplo.pokemon.model;

import java.util.Objects;

public class Pokemon {
    private int id;
    private String nombre;
    private String tipo;
    private int nivel;
    private int ps;

    public Pokemon() {
    }

    public Pokemon(int id, String nombre, String tipo, int nivel, int ps) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.ps = ps;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPs() {
        return ps;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return id == pokemon.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}