package com.endCom.PokeServicesV2.controller;


import com.endCom.PokeServicesV2.PokemonDTO.PokeApiCl;
import com.endCom.PokeServicesV2.PokemonDTO.PokemonDTO;
import com.endCom.PokeServicesV2.general.RespuestaServicio;
import com.endCom.PokeServicesV2.modelo.PokeApi;
import com.endCom.PokeServicesV2.modelo.Pokemon;
import com.endCom.PokeServicesV2.service.IPokemonService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/servicesPokemon")
public class PokemonController  implements Serializable {

    @Autowired
    private IPokemonService iPokemonService;

    @Autowired
    private RestTemplate restTemplate;



    @GetMapping("/help")
    public ResponseEntity<RespuestaServicio<String>> metodoHolaMundoPrueba(){
        final RespuestaServicio<String> respuesta = new RespuestaServicio<>();

        try {
            String lista = "NOTA: Podemos cambiar el puesto de servidor en el archivo  application.properties.\n" +
                    "ESTATUS (90% DE LO REQUERIDO)\n" +
                    "•\thttp://localhost:9091/api/servicesPokemon/pokeApiComplet?extract=30\n" +
                    "\n" +
                    "Esta liga hace referencia al primer servicio requerido se sugiere que se consuma de esta forma ya que las Api anidadas para realizar el servicio .\n" +
                    "\n" +
                    "\n" +
                    "ESTATUS (100% DE LO REQUERIDO)\n" +
                    "•\thttp://localhost:9091/api/servicesPokemon/pokeApiRangos?rango1=50&rango2=80\n" +
                    "\n" +
                    "Esta liga hace referencia al segundo servicio requerido cabe mencionar que el parámetro rango1 siempre deberá ser menor al rango2 para poder obtener datos.\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "ESTATUS (100% DE LO REQUERIDO)\n" +
                    "•\thttp://localhost:9091/api/servicesPokemon/pokeApiFinByPokemonOrNum?para=50 \n" +
                    "\n" +
                    "•\thttp://localhost:9091/api/servicesPokemon/pokeApiFinByPokemonOrNum?para=diglett\n" +
                    "\n" +
                    "Podemos consultar el tercer servicio con cualquiera de estas ligas ya que la única variante es el parámetro puede ser un numero o nombre un pokemon siempre y cuando existan devolverá datos.\n" +
                    "\n" +
                    "\n" +
                    "ESTATUS (100% DE LO REQUERIDO)\n" +
                    "•\thttp://localhost:9091/api/servicesPokemon/guardar\n" +
                    "\n" +
                    "Esta liga hace referencia al cuarto servicio el cual consiste en guardar un pokemon en nuestra base de datos H2, debemos recordar que el tipo de petición debe ser de tipo POST\n" +
                    "Y podemos mandar el cuerpo de un objeto como este:\n" +
                    "\n" +
                    "\n" +
                    " {\n" +
                    "   \"apodo\":\"pikachduu\",\n" +
                    "   \"especie\":\"elec\",\n" +
                    "   \"ataque\":null,\n" +
                    "   \"defensa\":null,\n" +
                    "   \"salud\":null\n" +
                    "}\n" +
                    "\n" +
                    "Los  atributos ataque, defensa y salud deberán ser null ya que es sistema se encargara de llenarlos automáticamente para poder insertar con éxito no debemos insertar un registro con un apodo que ya exista en la base de datos.\n" +
                    "\n" +
                    "\n" +
                    "ESTATUS (100% DE LO REQUERIDO)\n" +
                    "•\thttp://localhost:9091/api/servicesPokemon/findByApodo?apodo=pikachuudd\n" +
                    "\n" +
                    "Podemos consultar el quinto servicio requerido en el TEST mediante la liga definida solo debemos cambiar el apodo por uno que si exista en la base de datos, podemos apoyarnos a verificar que pokemones hay en la base datos de este servicio extra:\n" +
                    "\n" +
                    "•\thttp://localhost:9091/api/servicesPokemon/obtenerPokemonesH2\n" +
                    "\n" +
                    "ESTATUS (100% DE LO REQUERIDO)\n" +
                    "•\thttp://localhost:9091/api/servicesPokemon/pokeApiFinByPokemonOrNum?para=50 \n" +
                    "\n" +
                    "•\thttp://localhost:9091/api/servicesPokemon/pokeApiFinByPokemonOrNum?para=diglett\n" +
                    "\n" +
                    "Podemos consultar el tercer servicio con cualquiera de estas ligas ya que la única variante es el parámetro puede ser un numero o nombre un pokemon siempre y cuando existan devolverá datos.\n" +
                    "\n" +
                    "\n" +
                    "ESTATUS (100% DE LO REQUERIDO)\n" +
                    "•\thttp://localhost:9091/api/servicesPokemon/findAllByEspecie?especie=elec\n" +
                    "\n" +
                    "\n" +
                    "Podemos consultar el  sexto servicio con la liga definida anteriormente cabe mencionar que deberán existir pokemones con esa especie para poder obtener datos.\n" +
                    "\n" +
                    "\n" +
                    "\n";
            return respuesta.obtenerRespuesta(lista, "Datos obtenidos correctamente");
        } catch (Exception e) {

            return respuesta.obtenerRespuestaError("Ocurrio un error al obtener los datos");
        }
    }





    @GetMapping("/obtenerPokemonesH2")
    public ResponseEntity<RespuestaServicio<List<Pokemon>>> findAllDeH2(){
        final RespuestaServicio<List<Pokemon>> respuesta = new RespuestaServicio<>();

        try {
            List<Pokemon> lista = iPokemonService.findAll();


            return respuesta.obtenerRespuesta(lista, "Datos obtenidos correctamente");
        } catch (Exception e) {

            return respuesta.obtenerRespuestaError("Ocurrio un error al obtener los datos");
        }
    }


    @PostMapping("/guardar")
    public ResponseEntity<RespuestaServicio<Integer>> guardarPokemon(@RequestBody PokemonDTO pokemon){
        final RespuestaServicio<Integer> respuesta = new RespuestaServicio<>();
        try {
            int res = iPokemonService.savePokemon(pokemon);
            return respuesta.obtenerRespuesta(res, "Datos Insertados correctamente");
        } catch (Exception e) {

            return respuesta.obtenerRespuestaError("Ya existe ese apodo en la base de datos");
        }
    }



    @GetMapping("/findByApodo")
    public ResponseEntity<RespuestaServicio<PokemonDTO>> findByApodo(@RequestParam String apodo){
        final RespuestaServicio<PokemonDTO> respuesta = new RespuestaServicio<>();

        try {
            PokemonDTO pok = iPokemonService.findPokemonByApodo(apodo);


            return respuesta.obtenerRespuesta(pok, "Pokemon obtenidos correctamente");
        } catch (Exception e) {

            return respuesta.obtenerRespuestaError("Ese apodo no existe");
        }
    }


    @GetMapping("/findAllByEspecie")
    public ResponseEntity<RespuestaServicio<List<Pokemon>>> findAllByEspecie(@RequestParam String especie){
        final RespuestaServicio<List<Pokemon>> respuesta = new RespuestaServicio<>();

        try {
            List<Pokemon> lista = iPokemonService.findAllByEspecie(especie);


            return respuesta.obtenerRespuesta(lista, "Datos obtenidos correctamente");
        } catch (Exception e) {

            return respuesta.obtenerRespuestaError("Ocurrio un error al obtener los datos");
        }
    }


    // apis

    @GetMapping("/findAllForApi")
    public ResponseEntity<RespuestaServicio< List<PokeApi> >> findAllForApi(){
        final RespuestaServicio< List<PokeApi>> respuesta = new RespuestaServicio<>();
        String urlOne = "https://pokeapi.co/api/v2/pokemon?limit=10";
        PokeApi[] res = restTemplate.getForObject(urlOne, PokeApi[].class);
        List<PokeApi> response= Arrays.asList(res);

        try {
            return respuesta.obtenerRespuesta( response, "Datos obtenidos correctamente");
        } catch (Exception e) {
            return respuesta.obtenerRespuestaError("Ocurrio un error al obtener los datos");
        }
    }







    @GetMapping("/pokeApiObj2")
    public List<PokeApi> nameList() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://pokeapi.co/api/v2/pokemon?limit=10";
        PokeApi[] response = restTemplate.getForObject(fooResourceUrl, PokeApi[].class);
        List<PokeApi> response2= Arrays.asList(response);
        return response2;
    }

    @GetMapping("/pokeApiObj3")
    public List<ResponseEntity<PokeApi[]>> nameList2() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://pokeapi.co/api/v2/pokemon?limit=10";
      ResponseEntity <PokeApi[]> response = restTemplate.getForEntity(fooResourceUrl, PokeApi[].class);
       List<ResponseEntity<PokeApi[]>> response2 = Arrays.asList(response);
        return response2;
    }

//

    @GetMapping("/pokeApi")
    public ResponseEntity<String> name() throws JsonMappingException, JsonProcessingException, JSONException {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://pokeapi.co/api/v2/pokemon?limit=10";
        ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode name  = root.get("results");
        JSONArray array = new JSONArray(name.toString());
        System.out.println("mmm" + array.getJSONObject(0).getString("name"));
        System.out.println("mmm" + array.getJSONObject(0).getString("url"));

        return response;
    }



    @GetMapping("/pokeApi1")
    public ResponseEntity<Object> name4() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://pokeapi.co/api/v2/";
        ResponseEntity<Object> response = restTemplate.getForEntity(fooResourceUrl, Object.class);

        return response;
    }

    ///entregar

    @GetMapping("/pokeApiComplet")
    public List<PokeApiCl> finfByall(@RequestParam int extract) throws JsonProcessingException, JSONException {
        List<PokeApiCl> listaCompleta = iPokemonService.findAllByApi(extract);
        return listaCompleta;
    }

    @GetMapping("/pokeApiRangos")
    public List<PokeApiCl> pokeApiRangos(@RequestParam int rango1, @RequestParam int rango2 ) throws JsonProcessingException, JSONException {
        List<PokeApiCl> listaCompleta = iPokemonService.findAllByRangos(rango1,rango2 );
        return listaCompleta;
    }


    @GetMapping("/pokeApiFinByPokemonOrNum")
    public PokeApiCl pokeApiFinByPokemonOrNum(@RequestParam String para ) throws JsonProcessingException, JSONException {
        PokeApiCl poke = iPokemonService.findAllByNumberOrName(para);
        return poke;
    }




}
