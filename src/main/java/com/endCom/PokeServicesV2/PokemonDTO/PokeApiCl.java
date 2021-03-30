package com.endCom.PokeServicesV2.PokemonDTO;

import java.util.List;

public class PokeApiCl {



    private String name;
    private int numeroPokemon;
    List<String> tipos;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumeroPokemon() {
        return numeroPokemon;
    }

    public void setNumeroPokemon(int numeroPokemon) {
        this.numeroPokemon = numeroPokemon;
    }

    public List<String> getTipos() {
        return tipos;
    }

    public void setTipos(List<String> tipos) {
        this.tipos = tipos;
    }

    public PokeApiCl(String name, int numeroPokemon, List<String> tipos) {
        this.name = name;
        this.numeroPokemon = numeroPokemon;
        this.tipos = tipos;
    }

    public  PokeApiCl (){
        super();
    }
}
