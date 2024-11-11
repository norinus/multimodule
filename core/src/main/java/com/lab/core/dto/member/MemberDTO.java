package com.lab.core.dto.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.lab.core.domain.MemberRole;
import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(description = "이메일 주소", requiredMode = Schema.RequiredMode.REQUIRED)
    private String email;

    /**
     * 멤버의 이름
     */
    @Schema(description = "이름", requiredMode = Schema.RequiredMode.REQUIRED)
    private String name;

    /**
     * 멤버의 비밀번호
     */
    @Schema(description = "비밀번호", requiredMode = Schema.RequiredMode.REQUIRED)
    private String password;

    /**
     * 멤버의 휴대전화 번호
     */
    @Schema(description = "휴대전화 번호", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String mobileNumber;

    /**
     * 멤버가 삭제되었는지를 나타내는 플래그
     */
    @Schema(description = "삭제플래그", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean isDeleted;

    /**
     * 멤버가 제한되었는지를 나타내는 플래그
     */
    @Schema(description = "제한플래그", requiredMode = Schema.RequiredMode.REQUIRED)
    private Boolean isRestricted;

    /**
     * 멤버 제한 사유, 해당되는 경우
     */
    @Schema(description = "제한 사유", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private String restrictedReason;

    /**
     * 멤버 상태를 나타내는 코드
     */
    @Schema(description = "멤버상태코드", requiredMode = Schema.RequiredMode.REQUIRED)
    private String memberStateCode;

    /**
     * 멤버에게 할당된 역할 목록
     */
    @Schema(description = "역할 목록", requiredMode = Schema.RequiredMode.REQUIRED)
    private List<MemberRoleDTO> memberRoles;

    /**
     * 이 멤버 기록을 생성한 엔티티의 사용자 이름 또는 식별자
     */
    @Schema(description = "생성자", requiredMode = Schema.RequiredMode.REQUIRED)
    private String createdBy;

    /**
     * 멤버 기록이 생성된 날짜 및 시간
     */
    @Schema(description = "생성일", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Instant createdDate;

    /**
     * 이 멤버 기록을 마지막으로 수정한 엔티티의 사용자 이름 또는 식별자
     */
    @Schema(description = "수정자", requiredMode = Schema.RequiredMode.REQUIRED)
    private String LastModifiedBy;

    /**
     * 멤버 기록이 마지막으로 수정된 날짜 및 시간
     */
    @Schema(description = "수정일", requiredMode = Schema.RequiredMode.REQUIRED)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Instant LastModifiedDate;
}