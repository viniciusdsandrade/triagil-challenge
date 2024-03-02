package com.restful.triagil.challenge.dto.team;

import com.restful.triagil.challenge.dto.pokemon.DadosListagemPokemon;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.context.annotation.Description;

import java.util.List;

@Schema(name = "DadosDetalhamentoTeam",
        description = "Dados de Detalhamento de Times")
public record DadosDetalhamentoTeam(
        Long id,
        String owner,
        List<DadosListagemPokemon> pokemons
) {
}
