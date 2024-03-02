package com.restful.triagil.challenge.service.impl;

import com.restful.triagil.challenge.dto.team.DadosCadastroTeam;
import com.restful.triagil.challenge.dto.team.DadosDetalhamentoTeam;
import com.restful.triagil.challenge.dto.pokemon.DadosListagemPokemon;
import com.restful.triagil.challenge.entity.Team;
import com.restful.triagil.challenge.repository.TeamRepository;
import com.restful.triagil.challenge.service.PokemonService;
import com.restful.triagil.challenge.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final PokemonService pokemonService;

    public TeamServiceImpl(TeamRepository teamRepository,
                           PokemonService pokemonService) {
        this.teamRepository = teamRepository;
        this.pokemonService = pokemonService;
    }

    @Override
    public List<DadosDetalhamentoTeam> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        List<DadosDetalhamentoTeam> result = new ArrayList<>();

        for (Team team : teams) {
            List<DadosListagemPokemon> pokemons = team.getPokemons().stream()
                    .map(pokemonService::getPokemonById)
                    .map(this::convertToDadosListagemPokemon)
                    .collect(Collectors.toList());

            result.add(new DadosDetalhamentoTeam(team.getId(), team.getOwner(), pokemons));
        }

        return result;
    }

    @Override
    public Team getTeamByUserName(String name) {
        return teamRepository.findByName(name);
    }

    @Override
    public Team createTeam(DadosCadastroTeam team) {
        List<String> validPokemons = team.team().stream()
                .filter(pokemonService::isValidPokemon)
                .toList();

        Team newTeam = new Team();
        newTeam.setOwner(team.user());
        newTeam.setPokemons(validPokemons);

        return teamRepository.save(newTeam);
    }

    private DadosListagemPokemon convertToDadosListagemPokemon(DadosListagemPokemon pokemon) {
        return new DadosListagemPokemon(
                pokemon.id(),
                pokemon.name(),
                pokemon.baseExperience(),
                pokemon.height(),
                pokemon.isDefault(),
                pokemon.order(),
                pokemon.weight()
        );
    }
}
