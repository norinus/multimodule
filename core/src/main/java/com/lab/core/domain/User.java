package com.lab.core.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "tbl_user")
public class User extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_name", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "member_state_code", nullable = false)
    private String memberStateCode;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted;

}