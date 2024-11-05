package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tbl_qanda_image", schema = "fastapi")
public class QandaImage {
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
    @JoinColumn(name = "QANDA_ID", nullable = false)
    private com.lab.api.TblQanda qanda;

}