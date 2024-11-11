package com.lab.core.mapper.member;

import com.lab.core.domain.Member;
import com.lab.core.domain.MemberRole;
import com.lab.core.dto.member.MemberDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-11T10:57:14+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.10.2.jar, environment: Java 21.0.3 (Oracle Corporation)"
)
@Component
public class MemberMapperImpl implements MemberMapper {

    @Override
    public MemberDTO toDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDTO memberDTO = new MemberDTO();

        memberDTO.setId( member.getId() );
        memberDTO.setEmail( member.getEmail() );
        memberDTO.setName( member.getName() );
        memberDTO.setPassword( member.getPassword() );
        memberDTO.setMobileNumber( member.getMobileNumber() );
        memberDTO.setIsDeleted( member.getIsDeleted() );
        memberDTO.setIsRestricted( member.getIsRestricted() );
        memberDTO.setRestrictedReason( member.getRestrictedReason() );
        memberDTO.setMemberStateCode( member.getMemberStateCode() );
        List<MemberRole> list = member.getMemberRoles();
        if ( list != null ) {
            memberDTO.setMemberRoles( new ArrayList<MemberRole>( list ) );
        }
        memberDTO.setCreatedBy( member.getCreatedBy() );
        memberDTO.setCreatedDate( member.getCreatedDate() );
        memberDTO.setLastModifiedBy( member.getLastModifiedBy() );
        memberDTO.setLastModifiedDate( member.getLastModifiedDate() );

        return memberDTO;
    }

    @Override
    public Member toEntity(MemberDTO memberDTO) {
        if ( memberDTO == null ) {
            return null;
        }

        Member member = new Member();

        member.setCreatedBy( memberDTO.getCreatedBy() );
        member.setCreatedDate( memberDTO.getCreatedDate() );
        member.setLastModifiedBy( memberDTO.getLastModifiedBy() );
        member.setLastModifiedDate( memberDTO.getLastModifiedDate() );
        member.setId( memberDTO.getId() );
        member.setEmail( memberDTO.getEmail() );
        member.setName( memberDTO.getName() );
        member.setPassword( memberDTO.getPassword() );
        member.setMobileNumber( memberDTO.getMobileNumber() );
        member.setIsDeleted( memberDTO.getIsDeleted() );
        member.setIsRestricted( memberDTO.getIsRestricted() );
        member.setRestrictedReason( memberDTO.getRestrictedReason() );
        member.setMemberStateCode( memberDTO.getMemberStateCode() );
        List<MemberRole> list = memberDTO.getMemberRoles();
        if ( list != null ) {
            member.setMemberRoles( new ArrayList<MemberRole>( list ) );
        }

        return member;
    }
}
