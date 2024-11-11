package com.enum_exercise;

import java.util.Arrays;
import java.util.List;

public class RestaurantOrderingApp {
    public static void main(String[] args) {
        MenuRepository menuService = getMenuRepository();

        System.out.println();
        System.out.println("Appetizers:");
        menuService.searchByCategory(Category.APPETIZER).forEach(System.out::println);
        System.out.println();
        System.out.println("Main course:");
        menuService.searchByCategory(Category.MAIN_COURSE).forEach(System.out::println);
        System.out.println();
        System.out.println("Desserts:");
        menuService.searchByCategory(Category.DESSERT).forEach(System.out::println);
        System.out.println();
        System.out.println("Drinks:");
        menuService.searchByCategory(Category.DESSERT).forEach(System.out::println);

        OrderOperations order = new Order();

        Customer customer = new Customer("00001", "John Smith", order);

        System.out.println();
        System.out.println("Original order:");
        customer.addItemToOrder(menuService.findItemById("ITEM01"));
        customer.addItemToOrder(menuService.findItemById("ITEM02"));
        customer.displayOrderDetails();

        System.out.println();
        System.out.println("Updated order:");
        customer.removeItemFromOrder("ITEM02");
        customer.displayOrderDetails();
    }

    private static MenuRepository getMenuRepository() {
        List<MenuItem> menuItems = Arrays.asList(
                new MenuItem("ITEM01", "Bruschetta", 7.50, Category.APPETIZER),
                new MenuItem("ITEM02", "Caprese Salad", 8.00, Category.APPETIZER),

                // Main Courses
                new MenuItem("ITEM04", "Margherita Pizza", 12.00, Category.MAIN_COURSE),
                new MenuItem("ITEM05", "Lasagna Bolognese", 15.00, Category.MAIN_COURSE),
                new MenuItem("ITEM06", "Spaghetti Carbonara", 13.50, Category.MAIN_COURSE),

                new MenuItem("ITEM10", "Tiramisu", 6.50, Category.DESSERT),
                new MenuItem("ITEM11", "Panna Cotta", 5.50, Category.DESSERT),
                new MenuItem("ITEM13", "Gelato", 3.50, Category.DESSERT),

                // Drinks
                new MenuItem("ITEM14", "Espresso Martini", 3.50, Category.DRINK),
                new MenuItem("ITEM15", "Bellini", 7.00, Category.DRINK),
                new MenuItem("ITEM16", "Campari Soda", 7.00, Category.DRINK)
        );

        MenuRepository menuService = new MenuService(menuItems);
        return menuService;
    }
}
