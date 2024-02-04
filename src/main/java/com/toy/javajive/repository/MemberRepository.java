package com.toy.javajive.repository;

import com.toy.javajive.entity.MemberEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(MemberEntity member) {
        em.persist(member);
        return member.getId();
    }

    public MemberEntity find(Long id) {
        return em.find(MemberEntity.class, id);
    }
}
