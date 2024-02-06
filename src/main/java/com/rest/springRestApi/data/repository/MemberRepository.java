package com.rest.springRestApi.data.repository;

import com.rest.springRestApi.data.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
