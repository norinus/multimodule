package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_sub_category", schema = "fastapi")
public class SubCategory {
    @Id
    @Size(max = 20)
    @Column(name = "SUB_CATE_CODE", nullable = false, length = 20)
    private String subCateCode;

    @Size(max = 50)
    @NotNull
    @Column(name = "SUB_CATE_NAME", nullable = false, length = 50)
    private String subCateName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MAIN_CATE_CODE", nullable = false)
    private com.lab.api.TblMainCategory mainCateCode;

}