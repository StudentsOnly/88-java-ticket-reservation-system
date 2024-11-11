package com.enum_exercise;

import java.util.List;

interface MenuRepository {
    List<MenuItem> searchByCategory(Category category);
    MenuItem findItemById(String itemId);
    List<MenuItem> getAllMenuItems();
    public void displayAllMenuItems();
}
