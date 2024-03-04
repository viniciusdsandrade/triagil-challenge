package com.restful.triagil.challenge.controller;

import com.restful.triagil.challenge.dto.team.DadosCadastroTeam;
import com.restful.triagil.challenge.dto.team.DadosDetalhamentoTeam;
import com.restful.triagil.challenge.dto.team.DadosListagemTeam;
import com.restful.triagil.challenge.entity.Team;
import com.restful.triagil.challenge.service.TeamService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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

    @Operation(
            summary = "Cria um time de pokemons",
            description = "Cria um time de pokemons com base nos dados informados",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Time criado com sucesso"),
                    @ApiResponse(responseCode = "400", description = "Erro na requisição"),
                    @ApiResponse(responseCode = "409", description = "Time já existe"),
                    @ApiResponse(responseCode = "500", description = "Erro na aplicação")
            }
    )
    @PostMapping
    public ResponseEntity<DadosListagemTeam> createTeam(@RequestBody DadosCadastroTeam team) {
        Team newTeam = teamService.createTeam(team);
        return ResponseEntity.ok(new DadosListagemTeam(newTeam.getOwner(), newTeam.getPokemons()));
    }

    @Operation(
            summary = "Busca todos os times de pokemons",
            description = "Busca todos os times de pokemons cadastrados",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Times encontrados"),
                    @ApiResponse(responseCode = "404", description = "Nenhum time encontrado"),
                    @ApiResponse(responseCode = "500", description = "Erro na aplicação")
            }
    )
    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoTeam>> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @Operation(
            summary = "Busca um time de pokemons",
            description = "Busca um time de pokemons com base no nome do usuário",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Time encontrado"),
                    @ApiResponse(responseCode = "404", description = "Time não encontrado")
            }
    )
    @Parameter(name = "user", description = "Nome do usuário a ser buscado", required = true)
    @GetMapping("/name/{user}")
    public ResponseEntity<DadosListagemTeam> getTeamByUserName(@PathVariable("user") String name) {
        Team team = teamService.getTeamByUserName(name);
        return ResponseEntity.ok(new DadosListagemTeam(team.getOwner(), team.getPokemons()));
    }
}
