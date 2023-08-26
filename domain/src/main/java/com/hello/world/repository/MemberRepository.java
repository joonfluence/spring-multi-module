package com.hello.world.repository;

import com.hello.world.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Repository
public class MemberRepository {
    private final EntityManager em;

    @Transactional
    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }

    public Member findById(Long memberId){
        Member member = em.find(Member.class, memberId);
        if (Objects.isNull(member)){
            throw new InvalidDataAccessApiUsageException("존재하지 않는 값입니다");
        }
        return member;
    }

    public Member findWithTeamById(Long memberId){
        return em.createQuery("select m from Member m join fetch m.team t where m.id = :id", Member.class).setParameter("id", memberId).getSingleResult();
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m join fetch m.team t", Member.class).getResultList();
    }

    @Transactional
    public void update(Long id, String name){
        Member member1 = findById(id);
        member1.update(name);
    }

    @Transactional
    public void deleteById(Long id){
        Member member = findById(id);
        em.remove(member);
    }

    @Transactional
    public void detach(Member member){
        em.detach(member);
    }
}
