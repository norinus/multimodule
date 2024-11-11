package com.lab.core.mapper.member;

import com.lab.core.domain.Member;
import com.lab.core.dto.member.MemberDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {MemberRoleMapper.class})
public interface MemberMapper {

    MemberDTO toDto(Member member);

    Member toEntity(MemberDTO memberDTO);
}
