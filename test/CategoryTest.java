package com.enum_exercise;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CategoryTest {

    @Test
    void testCategoryValues() {
        assertEquals(4, Category.values().length);
        assertEquals("APPETIZER", Category.APPETIZER.toString());
        assertEquals("MAIN_COURSE", Category.MAIN_COURSE.toString());
        assertEquals("DESSERT", Category.DESSERT.toString());
        assertEquals("DRINK", Category.DRINK.toString());
    }

    @Test
    void testGetCategoryDescription() {
        assertEquals("A light dish as a starter", Category.APPETIZER.getDescription());
        assertEquals("The main dish of the meal", Category.MAIN_COURSE.getDescription());
        assertEquals("A sweet treat after the meal", Category.DESSERT.getDescription());
        assertEquals("A refreshing beverage", Category.DRINK.getDescription());
    }
}
