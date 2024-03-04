package com.restful.triagil.challenge.dto.team;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Schema(name = "DadosCadastroTeam",
        description = "Dados de Cadastro de Times")
public record DadosCadastroTeam(

        @NotNull(message = "User is required")
        @UniqueElements(message = "User already exists")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "User must contain only letters and numbers")
        String user,

        @NotNull(message = "Pokemons is required")
        List<String> team
) {
}
