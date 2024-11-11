package com.lab.core.dto.member;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lab.core.enums.RoleType;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "역할 유형", requiredMode = Schema.RequiredMode.REQUIRED)
    private RoleType role;

    /**
     * 이 멤버 역할 기록을 생성한 엔티티의 사용자 이름 또는 식별자
     */
    @Schema(description = "생성자", requiredMode = Schema.RequiredMode.REQUIRED)
    private String createdBy;

    /**
     * 멤버 역할이 생성된 날짜 및 시간
     */
    @Schema(description = "생성일", requiredMode = Schema.RequiredMode.REQUIRED)
    private Instant createdDate;

    /**
     * 이 멤버 역할을 마지막으로 수정한 엔티티의 사용자 이름 또는 식별자
     */
    @Schema(description = "수정자", requiredMode = Schema.RequiredMode.REQUIRED)
    private String LastModifiedBy;

    /**
     * 멤버 역할이 마지막으로 수정된 날짜 및 시간
     */
    @Schema(description = "수정일", requiredMode = Schema.RequiredMode.REQUIRED)
    private Instant LastModifiedDate;
}
