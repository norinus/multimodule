package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_member_card", schema = "fastapi")
public class TblMemberCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 150)
    @NotNull
    @Column(name = "CARD_NAME", nullable = false, length = 150)
    private String cardName;

    @Size(max = 16)
    @NotNull
    @Column(name = "CARD_NO", nullable = false, length = 16)
    private String cardNo;

    @Size(max = 150)
    @NotNull
    @Column(name = "CARD_USER_NAME", nullable = false, length = 150)
    private String cardUserName;

    @Size(max = 4)
    @NotNull
    @Column(name = "VALID_DATE", nullable = false, length = 4)
    private String validDate;

    @Size(max = 2)
    @NotNull
    @ColumnDefault("'01'")
    @Column(name = "VALID_STATE", nullable = false, length = 2)
    private String validState;

    @NotNull
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate;

    @NotNull
    @Column(name = "UPDATED_DATE", nullable = false)
    private Instant updatedDate;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private com.lab.api.TblMember member;

}