package com.enum_exercise;

public class Customer {
    private final String customerId;
    private final String name;
    private final OrderOperations order;

    public Customer(String customerId, String name, OrderOperations order) {
        this.customerId = customerId;
        this.name = name;
        this.order = order;
    }

    public void addItemToOrder(MenuItem item) {
        order.addItem(item);
    }

    public void removeItemFromOrder(String itemId) {
        try {
            order.removeItem(itemId);
        } catch (ItemNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayOrderDetails() {
        System.out.println("Customer: " + name);
        order.displayOrderItems();
        System.out.println("Total Price: " + order.calculateTotalPrice());
    }

    public String displayOrder() {
        return "Customer: " + name + "\n" + order.displayOrder();
    }
}
