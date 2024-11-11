package com.lab.core.mapper.member;

import com.lab.core.domain.Member;
import com.lab.core.domain.MemberRole;
import com.lab.core.dto.member.MemberDTO;
import com.lab.core.enums.RoleType;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {MemberRoleMapper.class})
public interface MemberMapper {

    @Mapping(target = "memberRoles", ignore = true) // 순환 참조 방지
    MemberDTO toDto(Member member);

    @Mapping(target = "memberRoles", ignore = true) // 순환 참조 방지
    Member toEntity(MemberDTO memberDTO);

    @AfterMapping
    default void setDefaultRole(@MappingTarget Member member) {

        member.setIsDeleted(false);
        member.setIsRestricted(false);
        member.setMemberStateCode("02");
        member.setCreatedBy(member.getName());
        member.setCreatedDate(Instant.now());
        member.setLastModifiedBy(member.getName());
        member.setLastModifiedDate(Instant.now());

        MemberRole role = new MemberRole();
        role.setRole(RoleType.USER);
        role.setMember(member);
        role.setCreatedBy(member.getName());
        role.setCreatedDate(Instant.now());
        role.setLastModifiedBy(member.getName());
        role.setLastModifiedDate(Instant.now());

        List<MemberRole> memberRoles = new ArrayList<>();
        memberRoles.add(role);
        member.setMemberRoles(memberRoles);
    }
}
