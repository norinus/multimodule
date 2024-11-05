package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_notice", schema = "fastapi")
public class TblNotice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 1000)
    @NotNull
    @Column(name = "CONTENTS", nullable = false, length = 1000)
    private String contents;

    @Size(max = 50)
    @NotNull
    @Column(name = "TITLE", nullable = false, length = 50)
    private String title;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IS_DELETE", nullable = false)
    private Boolean isDelete = false;

    @NotNull
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate;

    @NotNull
    @Column(name = "UPDATED_DATE", nullable = false)
    private Instant updatedDate;

}