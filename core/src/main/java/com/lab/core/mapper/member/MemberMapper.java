package com.lab.core.mapper.member;

import com.lab.core.domain.Member;
import com.lab.core.domain.MemberRole;
import com.lab.core.dto.member.MemberDTO;
import com.lab.core.enums.RoleType;
import com.lab.core.mapper.EntityMapper;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring", uses = {MemberRoleMapper.class})
public interface MemberMapper extends EntityMapper<MemberDTO, Member> {

    MemberDTO toDto(Member member);

    @Mapping(target = "memberRoles", ignore = true)
    Member toEntity(MemberDTO memberDTO);

    @AfterMapping
    default void setDefaultRole(@MappingTarget Member member) {

        if (member.getIsDeleted() == null) {
            member.setIsDeleted(false);
        }

        if (member.getIsRestricted() == null) {
            member.setIsRestricted(false);
        }

        if (member.getMemberStateCode() == null) {
            member.setMemberStateCode("02");
        }

        member.setCreatedBy(member.getName());
        /*member.setCreatedDate(Instant.now());*/
        member.setLastModifiedBy(member.getName());
        /*member.setLastModifiedDate(Instant.now());*/

        if (member.getMemberRoles() == null) {
            MemberRole role = new MemberRole();
            role.setRole(RoleType.USER);
            role.setMember(member);
            role.setCreatedBy(member.getName());
            /* role.setCreatedDate(Instant.now());*/
            role.setLastModifiedBy(member.getName());
            /*role.setLastModifiedDate(Instant.now());*/

            List<MemberRole> memberRoles = new ArrayList<>();
            memberRoles.add(role);
            member.setMemberRoles(memberRoles);
        }
    }
}
