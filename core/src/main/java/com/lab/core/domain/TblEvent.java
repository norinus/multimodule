package com.lab.core.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "tbl_event")
public class TblEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 50)
    @NotNull
    @Column(name = "TITLE", nullable = false, length = 50)
    private String title;

    @Size(max = 1000)
    @NotNull
    @Column(name = "CONTENTS", nullable = false, length = 1000)
    private String contents;

    @Size(max = 2)
    @NotNull
    @ColumnDefault("'02'")
    @Column(name = "EVENT_STATE", nullable = false, length = 2)
    private String eventState;

    @Size(max = 255)
    @NotNull
    @Column(name = "FILE_NAME", nullable = false)
    private String fileName;

    @Column(name = "START_DATE")
    private LocalDate startDate;

    @Column(name = "END_DATE")
    private LocalDate endDate;

    @NotNull
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate;

    @NotNull
    @Column(name = "UPDATED_DATE", nullable = false)
    private Instant updatedDate;

}