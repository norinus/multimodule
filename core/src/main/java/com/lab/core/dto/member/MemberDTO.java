package com.lab.core.dto.member;

import com.lab.core.domain.MemberRole;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.util.List;

/**
 * Member 엔티티를 위한 데이터 전송 객체 (DTO).
 * 이 DTO는 계층 간에 멤버 데이터를 전달하는 데 사용됩니다.
 */
@Getter
@Setter
public class MemberDTO {

    /**
     * 멤버의 고유 식별자
     */
    private Long id;

    /**
     * 멤버의 이메일 주소
     */
    private String email;

    /**
     * 멤버의 이름
     */
    private String name;

    /**
     * 멤버의 비밀번호
     */
    private String password;

    /**
     * 멤버의 휴대전화 번호
     */
    private String mobileNumber;

    /**
     * 멤버가 삭제되었는지를 나타내는 플래그
     */
    private Boolean isDeleted;

    /**
     * 멤버가 제한되었는지를 나타내는 플래그
     */
    private Boolean isRestricted;

    /**
     * 멤버 제한 사유, 해당되는 경우
     */
    private String restrictedReason;

    /**
     * 멤버 상태를 나타내는 코드
     */
    private String memberStateCode;

    /**
     * 멤버에게 할당된 역할 목록
     */
    private List<MemberRole> memberRoles;

    /**
     * 이 멤버 기록을 생성한 엔티티의 사용자 이름 또는 식별자
     */
    private String createdBy;

    /**
     * 멤버 기록이 생성된 날짜 및 시간
     */
    private Instant createdDate;

    /**
     * 이 멤버 기록을 마지막으로 수정한 엔티티의 사용자 이름 또는 식별자
     */
    private String LastModifiedBy;

    /**
     * 멤버 기록이 마지막으로 수정된 날짜 및 시간
     */
    private Instant LastModifiedDate;
}