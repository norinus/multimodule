package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_main_category", schema = "fastapi")
public class TblMainCategory {
    @Id
    @Size(max = 20)
    @Column(name = "MAIN_CATE_CODE", nullable = false, length = 20)
    private String mainCateCode;

    @Size(max = 50)
    @NotNull
    @Column(name = "MAIN_CATE_NAME", nullable = false, length = 50)
    private String mainCateName;

    @NotNull
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate;

    @NotNull
    @Column(name = "UPDATED_DATE", nullable = false)
    private Instant updatedDate;

}