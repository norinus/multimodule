package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tbl_subscribe", schema = "fastapi")
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @Column(name = "SUB_PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal subPrice;

    @NotNull
    @Column(name = "SUB_QUANTITY", nullable = false)
    private Integer subQuantity;

    @Size(max = 2)
    @NotNull
    @ColumnDefault("'01'")
    @Column(name = "SUB_STATE", nullable = false, length = 2)
    private String subState;

    @Column(name = "SUSPEND_DATE")
    private LocalDate suspendDate;

    @NotNull
    @Column(name = "SUBSCRIBE_DATE", nullable = false)
    private LocalDate subscribeDate;

    @NotNull
    @Column(name = "PAYMENT_DATE", nullable = false)
    private LocalDate paymentDate;

    @NotNull
    @Column(name = "SHIPPING_DATE", nullable = false)
    private LocalDate shippingDate;

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