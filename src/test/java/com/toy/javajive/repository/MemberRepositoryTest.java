package com.toy.javajive.repository;

import com.toy.javajive.entity.MemberEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    @Test
    @Rollback(false)
    public void testMember() throws Exception {

        MemberEntity member = new MemberEntity();
        member.setName("userTest1");

        Long saveId = memberRepository.save(member);
        MemberEntity findMember = memberRepository.find(member.getId());

        assertEquals(saveId, findMember.getId());

    }

}