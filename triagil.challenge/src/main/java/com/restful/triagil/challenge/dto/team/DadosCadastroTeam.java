package com.restful.triagil.challenge.dto.team;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

public record DadosCadastroTeam(

        @NotNull(message = "User is required")
        @UniqueElements(message = "User already exists")
        @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "User must contain only letters and numbers")
        String user,

        @NotNull(message = "Pokemons is required")
        List<String> team
) {
}
