package com.lab.core.domain;

import java.io.Serializable;
import java.util.Objects;

public class CommonCodeId implements Serializable {

    private String commonCode;
    private String commonGroupCode;

    public CommonCodeId() {
    }

    public CommonCodeId(String commonCode, String commonGroupCode) {
        this.commonCode = commonCode;
        this.commonGroupCode = commonGroupCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonCodeId that = (CommonCodeId) o;
        return Objects.equals(commonCode, that.commonCode) &&
                Objects.equals(commonGroupCode, that.commonGroupCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commonCode, commonGroupCode);
    }
}