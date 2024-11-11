package com.lab.core.repository.querydsl;

import com.lab.core.domain.Member;
import com.lab.core.domain.QMember;
import com.lab.core.dto.member.MemberDTO;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberQueryDslRepository {

    private final JPAQueryFactory queryFactory;

    private final QMember qMember = new QMember("qMember");

    public Page<MemberDTO> findByQueryList(Pageable pageable) {

        List<MemberDTO> result = queryFactory
                .select(
                        Projections.fields(
                                MemberDTO.class,
                                qMember.id,
                                qMember.name,
                                qMember.email
                        )
                )
                .from(qMember)
                .where(

                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPQLQuery<Member> count = queryFactory
                .selectFrom(qMember)
                .from(qMember);

        return PageableExecutionUtils.getPage(result, pageable, count::fetchCount);
    }
}

