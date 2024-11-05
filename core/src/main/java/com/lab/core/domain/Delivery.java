package com.lab.core.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_delivery", schema = "fastapi")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "COMPANY_NAME", nullable = false, length = 50)
    private String companyName;

    @Size(max = 150)
    @NotNull
    @Column(name = "DELIVERY_ADDR", nullable = false, length = 150)
    private String deliveryAddr;

    @Size(max = 20)
    @NotNull
    @Column(name = "DELIVERY_NO", nullable = false, length = 20)
    private String deliveryNo;

    @Size(max = 2)
    @NotNull
    @ColumnDefault("'01'")
    @Column(name = "DELIVERY_STATE", nullable = false, length = 2)
    private String deliveryState;

    @Size(max = 5)
    @NotNull
    @Column(name = "DLY_POST_NO", nullable = false, length = 5)
    private String dlyPostNo;

}