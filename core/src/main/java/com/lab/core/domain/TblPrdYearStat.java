package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_prd_year_stat", schema = "fastapi")
public class TblPrdYearStat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 12)
    @NotNull
    @Column(name = "PRODUCT_NO", nullable = false, length = 12)
    private String productNo;

    @Size(max = 50)
    @NotNull
    @Column(name = "PRODUCT_NAME", nullable = false, length = 50)
    private String productName;

    @Size(max = 4)
    @NotNull
    @Column(name = "YEAR", nullable = false, length = 4)
    private String year;

    @NotNull
    @Column(name = "SALE_TOTAL_PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal saleTotalPrice;

    @NotNull
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate;

    @NotNull
    @Column(name = "UPDATED_DATE", nullable = false)
    private Instant updatedDate;

}