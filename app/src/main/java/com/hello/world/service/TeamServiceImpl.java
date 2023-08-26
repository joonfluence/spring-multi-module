package com.hello.world.service;

import com.hello.world.domain.Team;
import com.hello.world.repository.TeamRepository;
import com.hello.world.web.TeamRequestDto;
import com.hello.world.web.TeamResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Transactional
    @Override
    public Long save(TeamRequestDto dto) {
        Team team = new Team();
        team.setName(dto.getName());
        teamRepository.save(team);
        return team.getId();
    }

    @Override
    public List<TeamResponseDto> findAll() {
        List<Team> teams = teamRepository.findAll();
        List<TeamResponseDto> dtos = new ArrayList<>();
        teams.forEach(t -> dtos.add(new TeamResponseDto(t.getId(), t.getName())));
        return dtos;
    }
}
