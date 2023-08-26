package com.hello.world.web;

import com.hello.world.domain.Team;
import com.hello.world.repository.TeamRepository;
import com.hello.world.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;

    @GetMapping("/v1/teams")
    public ResponseEntity<List<TeamResponseDto>> getTeams(){
        List<TeamResponseDto> teams = teamService.findAll();
        return new ResponseEntity(teams, HttpStatus.OK);
    }
}
