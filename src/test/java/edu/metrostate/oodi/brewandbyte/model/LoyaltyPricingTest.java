package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoyaltyPricingTest {

    @Test
    void memberGetsTheDiscount() {

        MenuItem coffee = new MenuItem(
                "Coffee", new BigDecimal("10.00"), "Available"
        );

        OrderItem coffeeItem = new OrderItem(
                coffee, 1, null, "Medium", null, new BigDecimal("10.00")
        );

        Order order = new Order(
                new Customer("Member", "Test Customer", "555-0100"),
                Arrays.asList(coffeeItem),
                "TEST-101",
                "pending",
                LocalDateTime.now(),
                new BigDecimal("10.00"),
                "",
                new LoyaltyDiscount()
        );

        assertEquals(
                new BigDecimal("9.0000"),
                order.getTotal()
        );
    }

    @Test
    void everyoneElsePaysFullPrice() {

        MenuItem coffee = new MenuItem(
                "Coffee", new BigDecimal("10.00"), "Available"
        );

        OrderItem coffeeItem = new OrderItem(
                coffee, 1, null, "Medium", null, new BigDecimal("10.00")
        );

        Order order = new Order(
                new Customer("Regular", "Test Customer", "555-0100"),
                Arrays.asList(coffeeItem),
                "TEST-102",
                "pending",
                LocalDateTime.now(),
                new BigDecimal("10.00"),
                "",
                new RegularDiscount()
        );

        assertEquals(
                new BigDecimal("10.00"),
                order.getTotal()
        );
    }
}