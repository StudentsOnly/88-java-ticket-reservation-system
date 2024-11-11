package com.enum_exercise;

import java.util.ArrayList;
import java.util.List;

public class Order implements OrderOperations {
    private final List<MenuItem> orderedItems = new ArrayList<>();

    @Override
    public void addItem(MenuItem item) {
        orderedItems.add(item);
    }

    @Override
    public void removeItem(String itemId) throws ItemNotFoundException {
        MenuItem itemToRemove = orderedItems.stream()
                .filter(item -> item.getItemId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + itemId + " not found."));
        orderedItems.remove(itemToRemove);
    }

    @Override
    public double calculateTotalPrice() {
        return orderedItems.stream().mapToDouble(MenuItem::getPrice).sum();

    }

    @Override
    public List<MenuItem> getOrderedItems() {
        return new ArrayList<>(orderedItems);
    }

    @Override
    public void displayOrderItems() {
        orderedItems.forEach(System.out::println);
    }

    public String displayOrder() {
        StringBuilder display = new StringBuilder();
        display.append("Order:\n");

        int index = 1;
        for (MenuItem item : orderedItems) {
            display.append(index++)
                    .append(". ")
                    .append(item.getName())
                    .append(" - $")
                    .append(String.format("%.2f", item.getPrice()))
                    .append("\n");
        }

        display.append("Total: $")
                .append(String.format("%.2f", calculateTotalPrice()));

        return display.toString();
    }
}
