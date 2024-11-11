import com.enum_exercise.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class OrderTest {

    private Order order;
    private MenuItem pizza;
    private MenuItem pasta;

    @BeforeEach
    void setUp() {
        order = new Order();
        pizza = new MenuItem("ITEM04", "Margherita Pizza", 12.00, Category.MAIN_COURSE);
        pasta = new MenuItem("ITEM06", "Spaghetti Carbonara", 13.50, Category.MAIN_COURSE);
    }

    @Test
    void testAddItem() {
        order.addItem(pizza);
        assertEquals(1, order.getOrderedItems().size());
        assertTrue(order.getOrderedItems().contains(pizza));
    }

    @Test
    void testRemoveItem() {
        order.addItem(pizza);
        order.addItem(pasta);
        order.removeItem(pizza.getItemId());
        assertEquals(1, order.getOrderedItems().size());
        assertFalse(order.getOrderedItems().contains(pizza));
    }

    @Test
    void testCalculateTotalPrice() {
        order.addItem(pizza);
        order.addItem(pasta);
        assertEquals(25.50, order.calculateTotalPrice());
    }

    @Test
    void testDisplayOrder() {
        order.addItem(pizza);
        order.addItem(pasta);
        String expectedDisplay = "Order:\n1. Margherita Pizza - $12.00\n2. Spaghetti Carbonara - $13.50\nTotal: $25.50";
        assertEquals(expectedDisplay, order.displayOrder());
    }
}
