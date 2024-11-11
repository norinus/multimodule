package com.lab.core.mapper.member;


import com.lab.core.domain.MemberRole;
import com.lab.core.dto.member.MemberRoleDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberRoleMapper {

    MemberRoleDTO toDto(MemberRole memberRole);

    MemberRole toEntity(MemberRoleDTO memberRoleDTO);
}
