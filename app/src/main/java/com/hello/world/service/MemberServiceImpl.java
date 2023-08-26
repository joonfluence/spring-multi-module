package com.hello.world.service;

import com.hello.world.domain.Member;
import com.hello.world.domain.Team;
import com.hello.world.repository.MemberRepository;
import com.hello.world.web.MemberRequestDto;
import com.hello.world.web.MemberResponseDto;
import com.hello.world.web.TeamResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    @Override
    public Long save(MemberRequestDto dto) {
        Team team = new Team();
        team.setName(dto.getTeam().getName());
        Member member = Member.createMemberWithTeam(dto.getName(), team);
        memberRepository.save(member);
        return member.getId();
    }

    @Override
    public List<MemberResponseDto> findAll() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponseDto> dtos = new ArrayList<>();
        members.forEach(m -> dtos.add(new MemberResponseDto(m.getId(), m.getName(), new TeamResponseDto(m.getTeam().getId(), m.getTeam().getName()))));
        return dtos;
    }
}
