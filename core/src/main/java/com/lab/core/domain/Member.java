package com.lab.core.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tbl_member")
@ToString
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // 고유 ID로 직렬화
public class Member extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @JsonManagedReference// 순환 참조 방지를 위해 제외
    @ToString.Exclude // 순환 참조 방지를 위해 제외
    //FetchType.EAGER 즉시 로딩
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private List<MemberRole> memberRoles;
}
