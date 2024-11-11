package com.lab.admin.repository.querydsl;

import com.lab.admin.dto.MemberQueryDTO;
import com.lab.core.domain.Member;
import com.lab.core.domain.QMember;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
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

    public Page<MemberQueryDTO> findByQueryList(Pageable pageable) {

        List<MemberQueryDTO> result = queryFactory
                .select(
                        Projections.fields(
                                MemberQueryDTO.class,
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

