import com.enum_exercise.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

    private Customer customer;
    private Order order;
    private MenuItem pizza;

    @BeforeEach
    void setUp() {
        order = new Order();
        customer = new Customer("00001", "John Smith", order);
        pizza = new MenuItem("ITEM04", "Margherita Pizza", 12.00, Category.MAIN_COURSE);
    }

    @Test
    void testAddItemToOrder() {
        customer.addItemToOrder(pizza);
        assertEquals(1, order.getOrderedItems().size());
        assertTrue(order.getOrderedItems().contains(pizza));
    }

    @Test
    void testRemoveItemFromOrder() {
        customer.addItemToOrder(pizza);
        customer.removeItemFromOrder(pizza.getItemId());
        assertEquals(0, order.getOrderedItems().size());
    }

    @Test
    void testDisplayCustomerOrder() {
        customer.addItemToOrder(pizza);
        String expected = "Customer: John Smith\nOrder:\n1. Margherita Pizza - $12.00\nTotal: $12.00";
        assertEquals(expected, customer.displayOrder());
    }
}
