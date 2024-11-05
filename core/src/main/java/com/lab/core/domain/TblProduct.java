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
@Table(name = "tbl_product", schema = "fastapi")
public class TblProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 12)
    @NotNull
    @Column(name = "PNO", nullable = false, length = 12)
    private String pno;

    @Size(max = 50)
    @NotNull
    @Column(name = "PRODUCT_NAME", nullable = false, length = 50)
    private String productName;

    @Size(max = 1000)
    @Column(name = "PRODUCT_DETAIL", length = 1000)
    private String productDetail;

    @NotNull
    @Column(name = "RETAIL_PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal retailPrice;

    @NotNull
    @Column(name = "SALE_PRICE", nullable = false, precision = 10, scale = 2)
    private BigDecimal salePrice;

    @Size(max = 50)
    @Column(name = "BRAND", length = 50)
    private String brand;

    @Size(max = 4)
    @NotNull
    @Column(name = "CATEGORY", nullable = false, length = 4)
    private String category;

    @Size(max = 50)
    @NotNull
    @Column(name = "SALE_COMPANY", nullable = false, length = 50)
    private String saleCompany;

    @Size(max = 1000)
    @Column(name = "SALE_COMPANY_INFO", length = 1000)
    private String saleCompanyInfo;

    @Size(max = 10)
    @Column(name = "TYPE", length = 10)
    private String type;

    @Size(max = 1000)
    @Column(name = "CAUTION", length = 1000)
    private String caution;

    @Size(max = 50)
    @NotNull
    @Column(name = "MANUFACTURE", nullable = false, length = 50)
    private String manufacture;

    @NotNull
    @Column(name = "MANUFACTURE_DATE", nullable = false)
    private LocalDate manufactureDate;

    @NotNull
    @Column(name = "EXPIRATION_DATE", nullable = false)
    private LocalDate expirationDate;

    @Size(max = 50)
    @NotNull
    @Column(name = "MATERIAL", nullable = false, length = 50)
    private String material;

    @Size(max = 1000)
    @Column(name = "NUTRITION", length = 1000)
    private String nutrition;

    @Size(max = 20)
    @NotNull
    @Column(name = "ORIGIN", nullable = false, length = 20)
    private String origin;

    @Column(name = "PACKAGE_QUANTITY")
    private Integer packageQuantity;

    @Column(name = "VOLUME")
    private Integer volume;

    @NotNull
    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "WISH_COUNT", nullable = false)
    private Integer wishCount;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "IS_VISIBLE", nullable = false)
    private Boolean isVisible = false;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IS_SOLDOUT", nullable = false)
    private Boolean isSoldout = false;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IS_GMO", nullable = false)
    private Boolean isGmo = false;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "IS_DELETED", nullable = false)
    private Boolean isDeleted = false;

    @NotNull
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate;

    @NotNull
    @Column(name = "UPDATED_DATE", nullable = false)
    private Instant updatedDate;

}