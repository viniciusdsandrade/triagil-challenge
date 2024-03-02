package com.restful.triagil.challenge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Team")
@Table(name = "tb_team",
        schema = "tb_triagil_challenge",
        uniqueConstraints = {
                @UniqueConstraint(name = "team_name_unique", columnNames = "owner")
        }
)
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;

    @ElementCollection
    private List<String> pokemons = new ArrayList<>();
}
