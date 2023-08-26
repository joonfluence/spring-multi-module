package com.hello.world.web;

import com.hello.world.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/v1/members")
    public ResponseEntity<List<MemberResponseDto>> getMembers(){
        List<MemberResponseDto> dtos = memberService.findAll();
        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    @PostMapping("/v1/members")
    public ResponseEntity createMember(@RequestBody MemberRequestDto dto){
        Long memberId = memberService.save(dto);
        return new ResponseEntity(memberId, HttpStatus.OK);
    }
}
