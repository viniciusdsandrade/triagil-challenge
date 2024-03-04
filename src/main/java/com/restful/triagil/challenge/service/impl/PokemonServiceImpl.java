package com.restful.triagil.challenge.service.impl;

import com.restful.triagil.challenge.dto.pokemon.DadosListagemPokemon;
import com.restful.triagil.challenge.exception.PokemonNotFoundException;
import com.restful.triagil.challenge.service.PokemonService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Override
    public boolean isValidPokemon(String pokemonName) {

        String pokemonNameToLowerCase = pokemonName.toLowerCase();

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;

        try {
            restTemplate.getForObject(url, String.class);
            return true;
        } catch (PokemonNotFoundException e) {
            return false;
        }
    }

    @Override
    public DadosListagemPokemon getPokemonById(String id) {

        RestTemplate restTemplate = new RestTemplate();
        String url = "https://pokeapi.co/api/v2/pokemon/" + id;

        try {
            return restTemplate.getForObject(url, DadosListagemPokemon.class);
        } catch (PokemonNotFoundException e) {
            return null;
        }
    }
}
