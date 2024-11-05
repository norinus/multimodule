package com.lab.core.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_age_year_stat", schema = "fastapi")
public class AgeYearStat  extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 2)
    @NotNull
    @Column(name = "AGE_GROUP", nullable = false, length = 2)
    private String ageGroup;

    @Size(max = 4)
    @NotNull
    @Column(name = "YEAR", nullable = false, length = 4)
    private String year;

    @NotNull
    @Column(name = "SALE_TOTAL_PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal saleTotalPrice;


}