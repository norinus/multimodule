package com.lab.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_member")
public class Member extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 120, nullable = false)
    private String email;

    @Column(length = 60, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)
    private String password;

    @Column(name = "mobile_number", length = 120)
    private String mobileNumber;

    @Column(name = "is_deleted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isDeleted = false;

    @Column(name = "is_restricted", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 0")
    private Boolean isRestricted = false;

    @Column(name = "restricted_reason", length = 1000)
    private String restrictedReason;

    @Column(name = "member_state_code", length = 2, nullable = false, columnDefinition = "VARCHAR(2) DEFAULT '01'")
    private String memberStateCode = "01";

    @OneToMany(mappedBy = "memberRole")
    private List<MemberRole> memberRoles;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "email = " + getEmail() + ", " +
                "name = " + getName() + ", " +
                "password = " + getPassword() + ", " +
                "mobileNumber = " + getMobileNumber() + ", " +
                "isDeleted = " + getIsDeleted() + ", " +
                "isRestricted = " + getIsRestricted() + ", " +
                "restrictedReason = " + getRestrictedReason() + ", " +
                "memberStateCode = " + getMemberStateCode() + ", " +
                "createdBy = " + getCreatedBy() + ", " +
                "createdDate = " + getCreatedDate() + ", " +
                "LastModifiedBy = " + getLastModifiedBy() + ", " +
                "lastModifiedDate = " + getLastModifiedDate() + ")";
    }
}
