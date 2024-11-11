import com.enum_exercise.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MenuItemTest {

    @Test
    void testMenuItemCreation() {
        MenuItem item = new MenuItem("ITEM01", "Margherita Pizza", 12.00, Category.MAIN_COURSE);
        assertNotNull(item);
        assertEquals("ITEM01", item.getItemId());
        assertEquals("Margherita Pizza", item.getName());
        assertEquals(12.00, item.getPrice());
        assertEquals(Category.MAIN_COURSE, item.getCategory());
    }

    @Test
    void testItemPrice() {
        MenuItem item = new MenuItem("ITEM02", "Lasagna", 15.00, Category.MAIN_COURSE);
        assertEquals(15.00, item.getPrice());
    }
}
