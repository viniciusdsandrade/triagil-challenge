package com.restful.triagil.challenge.service;

import com.restful.triagil.challenge.dto.pokemon.DadosListagemPokemon;

public interface PokemonService {

    boolean isValidPokemon(String pokemonName);

    DadosListagemPokemon getPokemonById(String s);
}
