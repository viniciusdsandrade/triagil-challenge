package com.restful.triagil.challenge.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Team")
@Table(name = "tb_team",
        uniqueConstraints = {
                @UniqueConstraint(name = "team_name_unique", columnNames = "owner")
        }
)
@Schema(description = "Entity representing a Pokemon team")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier of the Team")
    private Long id;

    @Schema(description = "Owner of the Team")
    private String owner;

    @ElementCollection
    @Schema(description = "List of Pokemons in the Team")
    @Setter(AccessLevel.NONE)
    private List<String> pokemons = new ArrayList<>();

    public void addPokemons(List<String> validPokemons) {
        pokemons.addAll(validPokemons);
    }
}
