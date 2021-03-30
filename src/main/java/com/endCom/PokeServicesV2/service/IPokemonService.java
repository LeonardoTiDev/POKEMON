package com.endCom.PokeServicesV2.service;

import com.endCom.PokeServicesV2.PokemonDTO.PokeApiCl;
import com.endCom.PokeServicesV2.PokemonDTO.PokemonDTO;
import com.endCom.PokeServicesV2.modelo.PokeApi;
import com.endCom.PokeServicesV2.modelo.Pokemon;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.json.JSONException;

import java.util.List;

public interface IPokemonService {

    public List<Pokemon> findAll();

    public PokemonDTO findPokemonByApodo(String apodo);

    public Integer savePokemon(PokemonDTO poke);

    public List<Pokemon> findAllByEspecie(String especie);

    public List<PokeApiCl> findAllByApi(int num) throws JsonMappingException, JsonProcessingException, JSONException;

    public List<PokeApiCl> findAllByRangos(int rango1, int rango2) throws JsonMappingException, JsonProcessingException, JSONException;

    public PokeApiCl  findAllByNumberOrName(String nuOrNa) throws JsonMappingException, JsonProcessingException, JSONException;


}
