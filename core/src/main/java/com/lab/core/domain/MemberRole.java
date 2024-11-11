package com.lab.core.domain;

import com.lab.core.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@Entity
@Table(name = "tbl_member_role")
public class MemberRole extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "role = " + getRole() + ", " +
                "createdBy = " + getCreatedBy() + ", " +
                "createdDate = " + getCreatedDate() + ", " +
                "LastModifiedBy = " + getLastModifiedBy() + ", " +
                "lastModifiedDate = " + getLastModifiedDate() + ")";
    }
}
