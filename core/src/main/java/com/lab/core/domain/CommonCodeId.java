package com.lab.core.domain;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
public class CommonCodeId implements Serializable {

    private String commonCode;

    private String commonGroupCode;
}