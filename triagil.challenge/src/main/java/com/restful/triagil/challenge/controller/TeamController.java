package com.restful.triagil.challenge.controller;

import com.restful.triagil.challenge.dto.team.DadosCadastroTeam;
import com.restful.triagil.challenge.dto.team.DadosDetalhamentoTeam;
import com.restful.triagil.challenge.dto.team.DadosListagemTeam;
import com.restful.triagil.challenge.entity.Team;
import com.restful.triagil.challenge.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/team")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping
    public ResponseEntity<DadosListagemTeam> createTeam(@RequestBody DadosCadastroTeam team) {
        Team newTeam = teamService.createTeam(team);
        return ResponseEntity.ok(new DadosListagemTeam(newTeam.getOwner(), newTeam.getPokemons()));
    }

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoTeam>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping("/{user}")
    public ResponseEntity<DadosListagemTeam> getTeamByUserName(@PathVariable("user") String name) {
        Team team = teamService.getTeamByUserName(name);
        return ResponseEntity.ok(new DadosListagemTeam(team.getOwner(), team.getPokemons()));
    }
}
