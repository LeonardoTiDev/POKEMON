package com.endCom.PokeServicesV2.service;


import com.endCom.PokeServicesV2.PokemonDTO.PokeApiCl;
import com.endCom.PokeServicesV2.PokemonDTO.PokemonDTO;
import com.endCom.PokeServicesV2.modelo.PokeApi;
import com.endCom.PokeServicesV2.modelo.Pokemon;
import com.endCom.PokeServicesV2.modeloDAO.IPokemonDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonServiceImpl implements IPokemonService{


    @Autowired
    private IPokemonDAO iPokemonDAO;



    @Override
    public List<Pokemon> findAll() {
        return iPokemonDAO.findAll();
    }

    @Override
    public PokemonDTO findPokemonByApodo(String apodo) {

        Pokemon pe = iPokemonDAO.findPokemonByApodo(apodo);

        PokemonDTO objecDTO = new PokemonDTO(pe.getApodo(), pe.getEspecie(), pe.getAtaque(), pe.getDefensa(), pe.getSalud(), pe.getIdPokemon());


        return objecDTO;
    }

    @Override
    public Integer savePokemon(PokemonDTO pokeDt) {

           boolean flag = iPokemonDAO.bander(pokeDt.getApodo());

           if (flag == true){
               return null;

           }

        Pokemon poke = new Pokemon();

        int ataque = (int) Math.floor(Math.random() * (0 - 15 + 1) + 15);
        int defensa = (int) Math.floor(Math.random() * (0 - 15 + 1) + 15);
        int salud = (int) Math.floor(Math.random() * (0 - 15 + 1) + 15);
        poke.setApodo(pokeDt.getApodo());
        poke.setEspecie(pokeDt.getEspecie());
        poke.setAtaque(ataque);
        poke.setDefensa(defensa);
        poke.setSalud(salud);
        iPokemonDAO.savePokemon(poke);

        return 1;

    }

    @Override
    public List<Pokemon> findAllByEspecie(String especie) {
        List<Pokemon> respuestaPoke = iPokemonDAO.findAllByEpecie(especie);

        return respuestaPoke;
    }

    @Override
    public List<PokeApiCl> findAllByApi(int num) throws JsonMappingException, JsonProcessingException, JSONException {






        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://pokeapi.co/api/v2/pokemon/?offset=1&limit=722";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode name  = root.get("results");
        JSONArray array = new JSONArray(name.toString());
        //second
        ArrayList<PokeApiCl> ListCompleta = new ArrayList<>();


        for (int i =1; i<=num; i++ ){
            ArrayList<String> tipos = new ArrayList<>();
            String nombrePokemon = array.getJSONObject(i).getString("name");
            RestTemplate restTemplate2 = new RestTemplate();
            StringBuilder s = new StringBuilder("https://pokeapi.co/api/v2/pokemon/");
            s.append(nombrePokemon);
            String urlTypes = s.toString();
            System.out.println("aqui la Url "  + urlTypes  );
            ResponseEntity<String> response2 = restTemplate2.getForEntity(urlTypes, String.class);
            ObjectMapper mapper2 = new ObjectMapper();
            JsonNode root2 = mapper2.readTree(response2.getBody());
            JsonNode name2  = root2.get("id");
            String numeroStr=name2.toString();


                JsonNode root3 = mapper2.readTree(response2.getBody());
                JsonNode name3 = root3.get("types");
                JSONArray array2 = new JSONArray(name3.toString());
                array2.iterator().forEachRemaining(a2-> {
                            JSONObject object2 = new JSONObject(a2.toString());
                            JSONObject object3 = new JSONObject(object2.getJSONObject("type").toString());
                            System.out.println(object3.getString("name"));
                            tipos.add(object3.getString("name"));
                        });

            PokeApiCl objePokeApicl = new PokeApiCl();
            objePokeApicl.setName(array.getJSONObject(i).getString("name"));
            objePokeApicl.setNumeroPokemon(Integer.parseInt(numeroStr));
            objePokeApicl.setTipos(tipos);
            ListCompleta.add(objePokeApicl);

        }

        return ListCompleta;
    }

    @Override
    public List<PokeApiCl> findAllByRangos(int rango1, int rango2) throws JsonMappingException, JsonProcessingException, JSONException {


        int num = rango2-rango1;


        RestTemplate restTemplate = new RestTemplate();
        StringBuilder cadenaOne = new StringBuilder("https://pokeapi.co/api/v2/pokemon/?offset=");
        cadenaOne.append(rango1);
        cadenaOne.append("&limit=");
        cadenaOne.append(rango2);

        String fooResourceUrl = cadenaOne.toString();
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode name  = root.get("results");
        JSONArray array = new JSONArray(name.toString());
        //second
        ArrayList<PokeApiCl> ListCompleta = new ArrayList<>();


        for (int i =1; i<=num; i++ ){
            ArrayList<String> tipos = new ArrayList<>();
            String nombrePokemon = array.getJSONObject(i).getString("name");
            RestTemplate restTemplate2 = new RestTemplate();
            StringBuilder s = new StringBuilder("https://pokeapi.co/api/v2/pokemon/");
            s.append(nombrePokemon);
            String urlTypes = s.toString();
            System.out.println("aqui la Url "  + urlTypes  );
            ResponseEntity<String> response2 = restTemplate2.getForEntity(urlTypes, String.class);
            ObjectMapper mapper2 = new ObjectMapper();
            JsonNode root2 = mapper2.readTree(response2.getBody());
            JsonNode name2  = root2.get("id");
            String numeroStr=name2.toString();


            JsonNode root3 = mapper2.readTree(response2.getBody());
            JsonNode name3 = root3.get("types");
            JSONArray array2 = new JSONArray(name3.toString());
            array2.iterator().forEachRemaining(a2-> {
                JSONObject object2 = new JSONObject(a2.toString());
                JSONObject object3 = new JSONObject(object2.getJSONObject("type").toString());
                System.out.println(object3.getString("name"));
                tipos.add(object3.getString("name"));
            });

            PokeApiCl objePokeApicl = new PokeApiCl();
            objePokeApicl.setName(array.getJSONObject(i).getString("name"));
            objePokeApicl.setNumeroPokemon(Integer.parseInt(numeroStr));
            objePokeApicl.setTipos(tipos);
            ListCompleta.add(objePokeApicl);

        }


        return ListCompleta;
    }

    @Override
    public PokeApiCl  findAllByNumberOrName(String nuOrNa) throws JsonMappingException, JsonProcessingException, JSONException {





        RestTemplate restTemplate = new RestTemplate();
        StringBuilder cadenaOne = new StringBuilder("https://pokeapi.co/api/v2/pokemon/");
        cadenaOne.append(nuOrNa);
        String fooResourceUrl = cadenaOne.toString();
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode name  = root.get("forms");
        JSONArray array = new JSONArray(name.toString());
        //second
        ArrayList<PokeApiCl> ListCompleta = new ArrayList<>();



            ArrayList<String> tipos = new ArrayList<>();
            String nombrePokemon = array.getJSONObject(0).getString("name");
            RestTemplate restTemplate2 = new RestTemplate();
            StringBuilder s = new StringBuilder("https://pokeapi.co/api/v2/pokemon/");
            s.append(nombrePokemon);
            String urlTypes = s.toString();
            System.out.println("aqui la Url "  + urlTypes  );
            ResponseEntity<String> response2 = restTemplate2.getForEntity(urlTypes, String.class);
            ObjectMapper mapper2 = new ObjectMapper();
            JsonNode root2 = mapper2.readTree(response2.getBody());
            JsonNode name2  = root2.get("id");
            String numeroStr=name2.toString();


            JsonNode root3 = mapper2.readTree(response2.getBody());
            JsonNode name3 = root3.get("types");
            JSONArray array2 = new JSONArray(name3.toString());
            array2.iterator().forEachRemaining(a2-> {
                JSONObject object2 = new JSONObject(a2.toString());
                JSONObject object3 = new JSONObject(object2.getJSONObject("type").toString());
                System.out.println(object3.getString("name"));
                tipos.add(object3.getString("name"));
            });

            PokeApiCl objePokeApicl = new PokeApiCl();
            objePokeApicl.setName(array.getJSONObject(0).getString("name"));
            objePokeApicl.setNumeroPokemon(Integer.parseInt(numeroStr));
            objePokeApicl.setTipos(tipos);




        return objePokeApicl;
    }


}
