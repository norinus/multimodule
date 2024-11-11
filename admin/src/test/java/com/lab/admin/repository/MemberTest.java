package com.lab.admin.repository;

import com.lab.core.domain.Member;
import com.lab.core.domain.MemberRole;
import com.lab.core.enums.RoleType;
import com.lab.core.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Slf4j
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void insertMember(){

        List<MemberRole> memberRoles = new ArrayList<>();
        MemberRole memberRole = new MemberRole();
        memberRole.setRole(RoleType.ADMIN);
        memberRoles.add(memberRole);

        Member member = new Member();
        member.setEmail("test1@test.com");
        member.setName("test1");
        member.setPassword("1234");
        member.setMemberRoles(memberRoles);
        member.setCreatedBy("SYSTEM");
        member.setCreatedDate(Instant.now());
        member.setLastModifiedBy("SYSTEM");
        member.setLastModifiedDate(Instant.now());
        memberRepository.save(member);
    }




}
