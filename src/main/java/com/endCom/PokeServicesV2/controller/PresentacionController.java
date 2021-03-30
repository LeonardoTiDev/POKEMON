package com.endCom.PokeServicesV2.controller;


import com.endCom.PokeServicesV2.PokemonDTO.PokeApiCl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pages")
public class PresentacionController {

    @GetMapping("/presentacionLeonardo")
    public String index() {
        return "index";
    }
}
