
package edu.metrostate.oodi.brewandbyte.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ManagerJobsTest {

    @Test
    void addsAnItemToTheMenu() {
        Menu menu = new Menu(List.of());
        ShopHandler shop = new ShopHandler(menu);

        shop.addItem("Coffee", new BigDecimal("4.50"), "Available");

        assertEquals(1, shop.getMenuItems().size());
        assertEquals("Coffee", shop.getMenuItems().get(0).getName());
        assertEquals(new BigDecimal("4.50"),
                     shop.getMenuItems().get(0).getPrice());
    }

    @Test
    void refusesAPriceOfZero() {
        Menu menu = new Menu(List.of());
        ShopHandler shop = new ShopHandler(menu);

        assertThrows(IllegalArgumentException.class, () ->
            shop.addItem("Coffee", BigDecimal.ZERO, "Available")
        );

        assertTrue(shop.getMenuItems().isEmpty());
    }
}
