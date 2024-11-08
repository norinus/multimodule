package com.lab.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "tbl_common_group_code")
public class CommonGroupCode extends AbstractAuditingEntity implements Serializable {

    @Id
    @Column(name = "common_group_code", length = 20, nullable = false)
    private String commonGroupCode;

    @Column(name = "common_group_code_name", length = 50, nullable = false)
    private String commonGroupCodeName;


    @OneToMany(mappedBy = "commonGroupCode")
    private List<CommonCode> commonCodes;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "commonGroupCode = " + commonGroupCode + ")";
    }
}
