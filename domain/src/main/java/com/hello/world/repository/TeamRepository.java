package com.hello.world.repository;

import com.hello.world.domain.Team;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Repository
public class TeamRepository {
    private final EntityManager em;

    @Transactional
    public Long save(Team team){
        em.persist(team);
        return team.getId();
    }

    public Team findById(Long teamId){
        Team team = em.find(Team.class, teamId);
        if (Objects.isNull(team)){
            throw new InvalidDataAccessApiUsageException("존재하지 않는 값입니다");
        }
        return team;
    }

    public List<Team> findAll(){
        return em.createQuery("select t from Team t").getResultList();
    }

    @Transactional
    public void update(Long id, String name){
        Team team1 = findById(id);
        team1.update(name);
    }

    @Transactional
    public void deleteById(Long id){
        Team team = findById(id);
        em.remove(team);
    }

    @Transactional
    public void detach(Team team){
        em.detach(team);
    }
}
