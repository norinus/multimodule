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
@Table(name = "tbl_age_quarter_stat")
public class AgeQuarterStat  extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 2)
    @NotNull
    @Column(name = "age_group", nullable = false, length = 2)
    private String ageGroup;

    @Size(max = 4)
    @NotNull
    @Column(name = "year", nullable = false, length = 4)
    private String year;

    @Size(max = 1)
    @NotNull
    @Column(name = "quarter", nullable = false, length = 1)
    private String quarter;

    @NotNull
    @Column(name = "sale_total_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal saleTotalPrice;
}