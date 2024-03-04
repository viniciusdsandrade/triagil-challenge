package com.restful.triagil.challenge.controller;

import com.restful.triagil.challenge.dto.pokemon.DadosListagemPokemon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/v1/pokemon")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PokemonController {

    @GetMapping("{name}")
    public ResponseEntity<DadosListagemPokemon> consultPokemon(@PathVariable("name") String name) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        DadosListagemPokemon pokemon = restTemplate.getForObject(url, DadosListagemPokemon.class);
        return ResponseEntity.ok(pokemon);
    }
}
