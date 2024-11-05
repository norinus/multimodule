package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_exchange", schema = "fastapi")
public class TblExchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 150)
    @NotNull
    @Column(name = "EX_ADDR", nullable = false, length = 150)
    private String exAddr;

    @Size(max = 50)
    @NotNull
    @Column(name = "EX_COMPANY_NAME", nullable = false, length = 50)
    private String exCompanyName;

    @Size(max = 5)
    @NotNull
    @Column(name = "EX_POST_NO", nullable = false, length = 5)
    private String exPostNo;

    @Size(max = 150)
    @NotNull
    @Column(name = "EX_REASON", nullable = false, length = 150)
    private String exReason;

    @Size(max = 20)
    @NotNull
    @Column(name = "EX_SHIPPING_NO", nullable = false, length = 20)
    private String exShippingNo;

    @Size(max = 2)
    @NotNull
    @ColumnDefault("'01'")
    @Column(name = "EXCHANGE_STATE", nullable = false, length = 2)
    private String exchangeState;

    @Size(max = 255)
    @NotNull
    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @Size(max = 150)
    @Column(name = "REJECT_REASON", length = 150)
    private String rejectReason;

    @Size(max = 50)
    @NotNull
    @Column(name = "RET_COMPANY_NAME", nullable = false, length = 50)
    private String retCompanyName;

    @Size(max = 20)
    @NotNull
    @Column(name = "RET_SHIPPING_NO", nullable = false, length = 20)
    private String retShippingNo;

    @Size(max = 150)
    @NotNull
    @Column(name = "RETURN_ADDR", nullable = false, length = 150)
    private String returnAddr;

    @NotNull
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate;

    @NotNull
    @Column(name = "UPDATED_DATE", nullable = false)
    private Instant updatedDate;

}