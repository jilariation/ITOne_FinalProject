package com.github.itonefinalproject.domain.enums;

public enum KindOfTaskEnum {
    MARKETING,
    LEGAL,
    EXTERNAL,
    DESIGN,
    PRODUCTION;

    public static KindOfTaskEnum fromString(String value) {
        return KindOfTaskEnum.valueOf(value.toUpperCase());
    }
}
