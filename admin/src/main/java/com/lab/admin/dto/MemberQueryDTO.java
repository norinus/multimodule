package com.lab.admin.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class MemberQueryDTO {
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

}
