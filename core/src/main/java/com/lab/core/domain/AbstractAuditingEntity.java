package com.lab.core.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * Base abstract class for entities which will hold definitions for created, last modified,
 * created by, last modified by attributes.
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
public abstract class AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    // 생성 시 값이 변경되지 않도록 설정
    @Column(name = "created_by", updatable = false)
    @JsonIgnore
    @CreatedBy
    private String createdBy;

    // 생성 시 값이 변경되지 않도록 설정
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    @CreatedDate
    private Instant createdDate;

    // 수정 시 값을 변경
    @JsonIgnore
    @Column(name = "last_modified_by", nullable = false)
    @LastModifiedBy
    private String LastModifiedBy;

    // 수정 시 값을 변경
    @JsonIgnore
    @Column(name = "last_modified_date", nullable = false)
    @LastModifiedDate
    private Instant lastModifiedDate;

    // 엔티티가 처음 저장되기 전에 호출 (createdDate, updatedDate 초기화)
    @PrePersist
    public void prePersist() {
        if (createdDate == null) {
            this.createdDate = Instant.now();
        }
        if (lastModifiedDate == null) {
            this.lastModifiedDate = Instant.now();
        }
    }

    // 엔티티가 업데이트되기 전에 호출 (updatedDate 갱신)
    @PreUpdate
    public void preUpdate() {
        this.lastModifiedDate = Instant.now();
    }
}
