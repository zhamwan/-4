package com.example.trainhome.configuration;

public enum RoleConfig {
    ROLE_CLIENT("CLIENT"),
    ROLE_COACH("COACH"),
    UNAUTHORIZED("UNAUTHORIZED");

    private final String name;

    RoleConfig(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
