package com.rest.springRestApi.repository;

import com.rest.springRestApi.entity.MemberEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    @Test
    @Rollback(false)
    public void testMember() throws Exception {
        MemberEntity member = MemberEntity.builder()
                .name("testUser1")
                .build();
        memberRepository.save(member);

        Optional<MemberEntity> findMember = memberRepository.findById(member.getId());

        assertEquals(member.getId(), findMember.get().getId());
    }

}