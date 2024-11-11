package com.lab.core.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.lab.core.enums.RoleType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;


@Getter
@Setter
@Entity
@ToString
@Table(name = "tbl_member_role")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id") // 고유 ID로 직렬화
public class MemberRole extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    @Enumerated(EnumType.STRING)
    private RoleType role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    @ToString.Exclude // 순환 참조 방지를 위해 제외
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;
}
