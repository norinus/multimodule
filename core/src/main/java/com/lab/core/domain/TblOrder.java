package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tbl_order", schema = "fastapi")
public class TblOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "TOTAL_ORDER_PRICE", precision = 10, scale = 2)
    private BigDecimal totalOrderPrice;

    @NotNull
    @Column(name = "ORDER_DATE", nullable = false)
    private LocalDate orderDate;

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

}