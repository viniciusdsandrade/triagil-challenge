package com.restful.triagil.challenge.dto.pokemon;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "DadosListagemPokemon",
        description = "Dados de Listagem de Pokemons")
public record DadosListagemPokemon(
        Long id,
        String name,
        int baseExperience,
        int height,
        boolean isDefault,
        int order,
        int weight
) {

    public DadosListagemPokemon(DadosListagemPokemon dadosListagemPokemon) {
        this(
                dadosListagemPokemon.id(),
                dadosListagemPokemon.name(),
                dadosListagemPokemon.baseExperience(),
                dadosListagemPokemon.height(),
                dadosListagemPokemon.isDefault(),
                dadosListagemPokemon.order(),
                dadosListagemPokemon.weight()
        );
    }
}
