package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_product_image", schema = "fastapi")
public class TblProductImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 4)
    @NotNull
    @Column(name = "PRODUCT_TYPE", nullable = false, length = 4)
    private String productType;

    @Size(max = 255)
    @NotNull
    @Column(name = "PRODUCT_FILE_NAME", nullable = false)
    private String productFileName;

    @NotNull
    @Column(name = "SORT_NUM", nullable = false)
    private Integer sortNum;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IS_DELETED", nullable = false)
    private Boolean isDeleted = false;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_ID", nullable = false)
    private com.lab.api.TblProduct product;

}