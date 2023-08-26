package com.hello.world.service;

import com.hello.world.web.MemberRequestDto;
import com.hello.world.web.MemberResponseDto;

import java.util.List;

public interface MemberService {
    Long save(MemberRequestDto dto);

    List<MemberResponseDto> findAll();
}
