package com.hello.world.service;

import com.hello.world.web.TeamRequestDto;
import com.hello.world.web.TeamResponseDto;

import java.util.List;

public interface TeamService {
    Long save(TeamRequestDto dto);
    List<TeamResponseDto> findAll();
}
