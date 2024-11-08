package com.lab.core.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "tbl_category")
public class Category extends AbstractAuditingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 255)
    private String name;

    @Column(name = "level" , nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer level = 0;

    @Column(name = "is_used", nullable = false, columnDefinition = "TINYINT(1) DEFAULT 1")
    private Boolean isUsed = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Category parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Category> categories;

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + getId() + ", " +
                "name = " + getName() + ", " +
                "level = " + getLevel() + ", " +
                "isUsed = " + getIsUsed() + ", " +
                "createdBy = " + getCreatedBy() + ", " +
                "createdDate = " + getCreatedDate() + ", " +
                "lastModifiedBy = " + getLastModifiedBy() + ", " +
                "lastModifiedDate = " + getLastModifiedDate() + ", " +
                "createdBy = " + getCreatedBy() + ", " +
                "createdDate = " + getCreatedDate() + ", " +
                "LastModifiedBy = " + getLastModifiedBy() + ", " +
                "lastModifiedDate = " + getLastModifiedDate() + ")";
    }
}
