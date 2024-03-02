package com.restful.triagil.challenge.dto.team;

import com.restful.triagil.challenge.dto.pokemon.DadosListagemPokemon;

import java.util.List;

public record DadosDetalhamentoTeam(
        Long id,
        String owner,
        List<DadosListagemPokemon> pokemons
) {
}
