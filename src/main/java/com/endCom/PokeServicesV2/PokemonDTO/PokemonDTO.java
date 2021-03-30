package com.endCom.PokeServicesV2.PokemonDTO;

public class PokemonDTO {

    private String name ;
    private String url;
    private String apodo;
    private String especie;
    private  int ataque;
    private int defensa;
    private int salud;
    private int numerodePokemon;

    public PokemonDTO (String apodo, String especie, int ataque, int defensa, int salud, int idPokemon ){
        super();

        this.apodo=apodo;
        this.especie=especie;
        this.ataque=ataque;
        this.defensa=defensa;
        this.salud=salud;
        this.numerodePokemon= idPokemon;

    }

    public PokemonDTO(){
        super();
    }

    public PokemonDTO(String name , String url){
        this.name= name;
        this.url=url;


    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getNumerodePokemon() {
        return numerodePokemon;
    }

    public void setNumerodePokemon(int numerodePokemon) {
        this.numerodePokemon = numerodePokemon;
    }
}
