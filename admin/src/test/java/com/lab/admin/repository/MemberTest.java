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

        Member member = new Member();
        member.setEmail("test@test.com");
        member.setName("test");
        member.setPassword("1234");

        member.setCreatedBy("SYSTEM");
        member.setCreatedDate(Instant.now());
        member.setLastModifiedBy("SYSTEM");
        member.setLastModifiedDate(Instant.now());


        List<MemberRole> memberRoles = new ArrayList<>();
        MemberRole memberRole = new MemberRole();
        memberRole.setRole(RoleType.ADMIN);
        memberRole.setMember(member);
        memberRole.setCreatedBy("SYSTEM");
        memberRole.setCreatedDate(Instant.now());
        memberRole.setLastModifiedBy("SYSTEM");
        memberRole.setLastModifiedDate(Instant.now());
        memberRoles.add(memberRole);
        member.setMemberRoles(memberRoles);

        memberRepository.save(member);
    }


    @Test
    void selectMember(){

        memberRepository.findById(5L).ifPresentOrElse(member->{
            log.info(member.toString());
        },()->{
            log.error("회원정보가 없습니다.");
        });

    }
}
