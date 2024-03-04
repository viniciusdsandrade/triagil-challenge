package com.restful.triagil.challenge.service;

import com.restful.triagil.challenge.dto.team.DadosCadastroTeam;
import com.restful.triagil.challenge.dto.team.DadosDetalhamentoTeam;
import com.restful.triagil.challenge.entity.Team;
import jakarta.validation.Valid;

import java.util.List;

public interface TeamService {

    Team createTeam(@Valid DadosCadastroTeam team);

    List<DadosDetalhamentoTeam>  getAllTeams();

    Team getTeamByUserName(String name);
}