package com.lab.core.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "tbl_common_code")
@IdClass(CommonCodeId.class)
public class CommonCode extends AbstractAuditingEntity implements Serializable {

    @Id
    @Column(name = "common_code", length = 20, nullable = false)
    private String commonCode;

    @Column(name = "common_code_name", length = 50, nullable = false)
    private String commonCodeName;

    @Column(name = "is_used", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private boolean isUsed;

    @Id
    @ManyToOne
    @JoinColumn(name = "common_group_code", nullable = false)
    private CommonGroupCode commonGroupCode;
}