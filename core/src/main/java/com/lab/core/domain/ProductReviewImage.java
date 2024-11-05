package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_product_review_image", schema = "fastapi")
public class ProductReviewImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 255)
    @NotNull
    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PRODUCT_REVIEW_ID", nullable = false)
    private com.lab.api.TblProductReview productReview;

}