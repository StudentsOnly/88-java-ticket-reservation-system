package com.enum_exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class MenuService implements MenuRepository {
    private final List<MenuItem> menuItems;

    public MenuService(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public List<MenuItem> searchByCategory(Category category) {
        return menuItems.stream()
                .filter(item -> item.getCategory() == category)
                .collect(Collectors.toList());
    }

    @Override
    public MenuItem findItemById(String itemId) {
        return menuItems.stream()
                .filter(item -> item.getItemId().equals(itemId))
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Item with ID " + itemId + " not found."));
    }

    @Override
    public List<MenuItem> getAllMenuItems() {
        return new ArrayList<>(menuItems);
    }

    @Override
    public void displayAllMenuItems() {
        System.out.println("Appetizers:");
        searchByCategory(Category.APPETIZER).forEach(System.out::println);
        System.out.println();
        System.out.println("Main course:");
        searchByCategory(Category.MAIN_COURSE).forEach(System.out::println);
        System.out.println();
        System.out.println("Desserts:");
        searchByCategory(Category.DESSERT).forEach(System.out::println);
        System.out.println();
        System.out.println("Drinks:");
        searchByCategory(Category.DESSERT).forEach(System.out::println);
    }
}
