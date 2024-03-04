package com.restful.triagil.challenge.dto.team;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

@Schema(name = "DadosListagemTeam",
        description = "Dados de Listagem de Times")
public record DadosListagemTeam(
        String user,
        List<String> team
) {
}
