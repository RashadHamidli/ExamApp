package com.company.entity;

import lombok.Getter;

@Getter
public enum Status {
    ACTIVE("A"),
    INACTIVE("I"),
    DELETED("D"),
    UPDATED("U");
    private final String code;

    Status(String code) {
        this.code = code;
    }
}
