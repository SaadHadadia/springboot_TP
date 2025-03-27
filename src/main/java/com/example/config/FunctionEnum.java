package com.example.config;

public enum FunctionEnum {
    ADMIN("Fonction administrative"),
    TECH("Fonction technique");

    private final String description;

    FunctionEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
