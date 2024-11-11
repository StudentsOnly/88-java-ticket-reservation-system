package com.enum_exercise;

public class MenuItem {
    private final String itemId;
    private final String name;
    private final double price;
    private final Category category;

    public MenuItem(String itemId, String name, double price, Category category) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.itemId = itemId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getItemId() { return itemId; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public Category getCategory() { return category; }

    @Override
    public String toString() {
        return String.format("Item: %s | Category: %s (%s) | Price: $%.2f",
                name, category.getDescription(), category.getCode(), price);
    }
}
