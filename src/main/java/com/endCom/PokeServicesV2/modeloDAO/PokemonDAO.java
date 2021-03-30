package com.endCom.PokeServicesV2.modeloDAO;


import com.endCom.PokeServicesV2.modelo.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PokemonDAO implements IPokemonDAO{

    @Autowired
    private JdbcTemplate template;


    @Override
    public List<Pokemon> findAll() {
        String sql = "SELECT * FROM c_pokemon";
        List<Pokemon> pokemones = template.query(sql, new BeanPropertyRowMapper<Pokemon>(Pokemon.class));
        return pokemones;
    }

    @Override
    public Pokemon findPokemonByApodo(String apodo) {
        String sql = "SELECT apodo, especie, ataque, defensa, salud, id_pokemon FROM c_pokemon where apodo = ?  ";
        Pokemon Per = template.queryForObject(sql, new Object[] {apodo}, new BeanPropertyRowMapper<Pokemon>(Pokemon.class));

        return Per;
    }

    @Override
    public Integer savePokemon(Pokemon poke) {

        String sql = "INSERT INTO c_pokemon (apodo, especie, ataque, defensa, salud) values (?,?,?,?,?)";
        int res = template.update(sql,  poke.getApodo(), poke.getEspecie(), poke.getAtaque(), poke.getDefensa(), poke.getSalud());
        return res;
    }

    @Override
    public List<Pokemon> findAllByEpecie(String spe) {

        String sql = "SELECT * FROM c_pokemon c where c.especie= "+"'"+spe+"'";
        System.out.println("queryyy" + sql);
        List<Pokemon> pokemones =template.query(sql, new BeanPropertyRowMapper<Pokemon>(Pokemon.class));
        return pokemones;
    }

    @Override
    public boolean bander(String apodo) {
        String sql = "SELECT * FROM c_pokemon p where p.apodo="+"'"+apodo+"'";
        List<Pokemon> pokemones = template.query(sql, new BeanPropertyRowMapper<Pokemon>(Pokemon.class));
        boolean bandera= !pokemones.isEmpty();
        System.out.println("aqui la bandera" +bandera);
        return bandera;
    }


}
