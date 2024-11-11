package com.enum_exercise;

import java.util.List;

interface OrderOperations {
    void addItem(MenuItem item);
    void removeItem(String itemId) throws ItemNotFoundException;
    double calculateTotalPrice();
    void displayOrderItems();
    public String displayOrder();
    List<MenuItem> getOrderedItems();
}
