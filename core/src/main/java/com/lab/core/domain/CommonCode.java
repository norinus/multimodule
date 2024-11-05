package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tbl_common_code", schema = "fastapi")
public class CommonCode {
    @EmbeddedId
    private CommonCodeId id;

    @Size(max = 50)
    @NotNull
    @Column(name = "COMMON_CODE_NAME", nullable = false, length = 50)
    private String commonCodeName;

    @NotNull
    @ColumnDefault("1")
    @Column(name = "IS_USED", nullable = false)
    private Boolean isUsed = false;

}