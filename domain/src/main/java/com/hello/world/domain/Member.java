package com.hello.world.domain;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Entity
public class Member extends BaseTimeEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    @ManyToOne(fetch = LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "team_id")
    private Team team;

    public void update(String name){
        this.name = name;
    }

    public void addTeam(Team team) {
        this.team = team;
        team.getMemberList().add(this);
    }

    public static Member createMemberWithTeam(String name, Team team) {
        Member member = Member.builder().name(name).build();
        member.addTeam(team);
        return member;
    }
}
