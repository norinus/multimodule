package com.lab.core.domain;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tbl_member")
public class Member  extends AbstractAuditingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Size(max = 120)
    @NotNull
    @Column(name = "user_email", nullable = false, length = 120)
    private String userEmail;

    @Size(max = 255)
    @NotNull
    @Column(name = "password", nullable = false)
    private String password;

    @Size(max = 15)
    @NotNull
    @Column(name = "name", nullable = false, length = 15)
    private String name;

    @Size(max = 11)
    @NotNull
    @Column(name = "mobile_no", nullable = false, length = 11)
    private String mobileNo;

    @Size(max = 11)
    @Column(name = "phone_no", length = 11)
    private String phoneNo;

    @Size(max = 10)
    @NotNull
    @Column(name = "birthday", nullable = false, length = 10)
    private String birthday;

    @Size(max = 2)
    @NotNull
    @Column(name = "age_group", nullable = false, length = 2)
    private String ageGroup;

    @Size(max = 1)
    @NotNull
    @Column(name = "gender", nullable = false, length = 1)
    private String gender;

    @NotNull
    @Column(name = "mileage", nullable = false)
    private Integer mileage;

    @Size(max = 150)
    @Column(name = "address", length = 150)
    private String address;

    @Size(max = 5)
    @Column(name = "post_code", length = 5)
    private String postCode;

    @Size(max = 150)
    @Column(name = "shipping_addr", length = 150)
    private String shippingAddr;

    @Size(max = 5)
    @Column(name = "ship_post_no", length = 5)
    private String shipPostNo;

    @Size(max = 150)
    @Column(name = "add_shipping_addr", length = 150)
    private String addShippingAddr;

    @Size(max = 5)
    @Column(name = "add_post_no", length = 5)
    private String addPostNo;

    @Size(max = 2)
    @NotNull
    @ColumnDefault("'01'")
    @Column(name = "member_state", nullable = false, length = 2)
    private String memberState;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "is_blacklist", nullable = false)
    private Boolean isBlacklist = false;

    @NotNull
    @ColumnDefault("0")
    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

}