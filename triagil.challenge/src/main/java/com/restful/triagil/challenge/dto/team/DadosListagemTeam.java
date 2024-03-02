package com.restful.triagil.challenge.dto.team;

import java.util.List;

public record DadosListagemTeam(
        String user,
        List<String> team
) {
}
