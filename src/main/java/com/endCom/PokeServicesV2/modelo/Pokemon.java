package com.endCom.PokeServicesV2.modelo;

public class Pokemon {

    private int idPokemon;
    private String apodo;
    private String especie;
    private  int ataque;
    private int defensa;
    private int salud;



    public int getIdPokemon() {
        return idPokemon;
    }

    public void setIdPokemon(int idPokemon) {
        this.idPokemon = idPokemon;
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



    public Pokemon (){


    }


    public Pokemon(int idPokemon, String apodo, String especie, int ataque, int defensa, int salud, String tipos) {
        this.idPokemon = idPokemon;
        this.apodo = apodo;
        this.especie = especie;
        this.ataque = ataque;
        this.defensa = defensa;
        this.salud = salud;

    }
}
