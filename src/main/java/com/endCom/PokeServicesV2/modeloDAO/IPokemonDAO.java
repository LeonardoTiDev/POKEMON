package com.endCom.PokeServicesV2.modeloDAO;

import com.endCom.PokeServicesV2.modelo.Pokemon;

import java.util.List;

public interface IPokemonDAO {

    public List<Pokemon> findAll();

    public Pokemon findPokemonByApodo(String apodo);

    public Integer savePokemon(Pokemon poke);

    public List<Pokemon> findAllByEpecie(String especie);

    public boolean bander(String apodo);

}
