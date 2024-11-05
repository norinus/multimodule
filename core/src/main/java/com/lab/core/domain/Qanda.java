package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_qanda", schema = "fastapi")
public class Qanda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "TITLE", nullable = false, length = 50)
    private String title;

    @Size(max = 1000)
    @NotNull
    @Column(name = "CONTENTS", nullable = false, length = 1000)
    private String contents;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IS_DELETED", nullable = false)
    private Boolean isDeleted = false;

    @NotNull
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate;

    @NotNull
    @Column(name = "UPDATED_DATE", nullable = false)
    private Instant updatedDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private com.lab.api.TblMember member;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private com.lab.api.TblProduct product;

}