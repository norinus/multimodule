package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "tbl_common_group_code", schema = "fastapi")
public class CommonGroupCode {
    @Id
    @Size(max = 20)
    @Column(name = "COMMON_GROUP_CODE", nullable = false, length = 20)
    private String commonGroupCode;

    @Size(max = 50)
    @NotNull
    @Column(name = "COMMON_GROUP_CODE_NAME", nullable = false, length = 50)
    private String commonGroupCodeName;

}