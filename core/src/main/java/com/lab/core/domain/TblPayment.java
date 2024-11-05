package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tbl_payment", schema = "fastapi")
public class TblPayment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 1000)
    @Column(name = "APPLY_NUM", length = 1000)
    private String applyNum;

    @Size(max = 150)
    @Column(name = "BANK_NAME", length = 150)
    private String bankName;

    @Size(max = 255)
    @Column(name = "BUYER_ADDR")
    private String buyerAddr;

    @Size(max = 255)
    @Column(name = "BUYER_EMAIL")
    private String buyerEmail;

    @Size(max = 50)
    @Column(name = "BUYER_NAME", length = 50)
    private String buyerName;

    @Size(max = 7)
    @Column(name = "BUYER_POSTCODE", length = 7)
    private String buyerPostcode;

    @Size(max = 13)
    @Column(name = "BUYER_TEL", length = 13)
    private String buyerTel;

    @Size(max = 255)
    @Column(name = "CARD_NAME")
    private String cardName;

    @Size(max = 19)
    @Column(name = "CARD_NUMBER", length = 19)
    private String cardNumber;

    @Size(max = 2)
    @ColumnDefault("'00'")
    @Column(name = "CARD_QUOTA", length = 2)
    private String cardQuota;

    @Size(max = 1000)
    @Column(name = "CUSTOM_DATA", length = 1000)
    private String customData;

    @Size(max = 10)
    @Column(name = "CURRENCY", length = 10)
    private String currency;

    @Size(max = 50)
    @Column(name = "CUSTOMER_UID", length = 50)
    private String customerUid;

    @Size(max = 20)
    @Column(name = "IMP_UID", length = 20)
    private String impUid;

    @Size(max = 50)
    @Column(name = "MERCHANT_UID", length = 50)
    private String merchantUid;

    @Size(max = 60)
    @Column(name = "NAME", length = 60)
    private String name;

    @Column(name = "PAID_AMOUNT")
    private Integer paidAmount;

    @Column(name = "PAID_AT")
    private Instant paidAt;

    @Size(max = 15)
    @Column(name = "PAID_METHOD", length = 15)
    private String paidMethod;

    @Size(max = 15)
    @Column(name = "PG_PROVIDER", length = 15)
    private String pgProvider;

    @Size(max = 30)
    @Column(name = "PG_TID", length = 30)
    private String pgTid;

    @Size(max = 15)
    @Column(name = "PG_TYPE", length = 15)
    private String pgType;

    @Size(max = 255)
    @Column(name = "RECEIPT_URL")
    private String receiptUrl;

    @Column(name = "EXPIRATION_DATE")
    private LocalDate expirationDate;

    @Size(max = 12)
    @ColumnDefault("'01'")
    @Column(name = "STATUS", length = 12)
    private String status;

    @Column(name = "SUCCESS")
    private Boolean success;

    @Size(max = 1000)
    @Column(name = "FAIL_REASON", length = 1000)
    private String failReason;

    @NotNull
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate;

    @NotNull
    @Column(name = "UPDATED_DATE", nullable = false)
    private Instant updatedDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ORDER_ID", nullable = false)
    private com.lab.api.TblOrder order;

}