package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_cart")
public class Cart  extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @OneToOne
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;
}