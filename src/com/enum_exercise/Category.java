package com.enum_exercise;

public enum Category {
    APPETIZER("A light dish as a starter", "A"),
    MAIN_COURSE("The main dish of the meal", "M"),
    DESSERT("A sweet treat after the meal", "D"),
    DRINK("A refreshing beverage", "R");

    private final String description;
    private final String code;

    Category(String description, String code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() { return description; }
    public String getCode() { return code; }
}
