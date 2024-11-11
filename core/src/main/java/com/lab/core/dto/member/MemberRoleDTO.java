package com.lab.core.dto.member;

import com.lab.core.enums.RoleType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

/**
 * MemberRole 엔티티를 위한 데이터 전송 객체 (DTO).
 * 이 DTO는 계층 간에 멤버 역할 데이터를 전달하는 데 사용됩니다.
 */
@Setter
@Getter
@ToString
public class MemberRoleDTO {

    /** 멤버 역할의 고유 식별자 */
    private Long id;

    /** 멤버의 역할 유형 */
    private RoleType role;

    private MemberDTO member;

    /** 이 멤버 역할 기록을 생성한 사용자 또는 엔티티 */
    private String createdBy;

    /** 멤버 역할 기록이 생성된 날짜 및 시간 */
    private Instant createdDate;

    /** 이 멤버 역할 기록을 마지막으로 수정한 사용자 또는 엔티티 */
    private String LastModifiedBy;

    /** 멤버 역할 기록이 마지막으로 수정된 날짜 및 시간 */
    private Instant lastModifiedDate;
}
