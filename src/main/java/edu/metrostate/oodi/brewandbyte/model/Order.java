package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Map;
import java.util.LinkedHashMap;

public class Order {

    private final Customer customer;
    private final List<OrderItem> items;
    private final String confirmationNumber;
    private String status;
    private final LocalDateTime dateAndTime;
    private LocalDateTime completedAt;
    private BigDecimal subtotal = BigDecimal.ZERO;
    private String note;
    private final DiscountHandler discountHandler;

    public Order(Customer customer, List<OrderItem> items,
                 String confirmationNumber, String status,
                 LocalDateTime dateAndTime, BigDecimal subtotal,
                 String note, DiscountHandler discountHandler) {

        this.customer = customer;
        this.items = new ArrayList<>(items);
        this.confirmationNumber = confirmationNumber;
        this.status = status;
        this.dateAndTime = dateAndTime;
        this.subtotal = subtotal;
        this.note = note;
        this.discountHandler = discountHandler;
    }

    public List<OrderItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public String getNote() {
        return note;
    }

    public String getConfirmationNumber() {
        return confirmationNumber;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getDateAndTime() {
        return dateAndTime;
    }

    public BigDecimal getTotal() {
        return calculateTotal();
    }

    public void markCompleted() {
        status = "Completed";
        completedAt = LocalDateTime.now();
    }

    public LocalDateTime getCompletedAt() {
        return completedAt;
    }

    public void addItem(OrderItem item) {
        throw new UnsupportedOperationException("not implemented");
    }

    public void removeItem(OrderItem item) {
        throw new UnsupportedOperationException("not implemented");
    }

    public BigDecimal calculateSubtotal() {

        subtotal = BigDecimal.ZERO;

        for (OrderItem item : items) {
            subtotal = subtotal.add(
                    item.getCost().multiply(
                            BigDecimal.valueOf(item.getQuantity())
                    )
            );
        }

        return subtotal;
    }

    public BigDecimal calculateTotal() {

        calculateSubtotal();

        BigDecimal discount = discountHandler.getDiscount(subtotal);

        return subtotal.subtract(discount);
    }

    public boolean consumeIngredients() {

        Map<Ingredient, Integer> required = new LinkedHashMap<>();

        // Collect base ingredients, milk, and syrup for every item
        for (OrderItem item : items) {
            int quantity = item.getQuantity();

            for (Map.Entry<Ingredient, Integer> entry :
                    item.getMenuItem().getIngredients().entrySet()) {

                required.merge(
                        entry.getKey(),
                        entry.getValue() * quantity,
                        Integer::sum
                );
            }

            if (item.getMilk() != null) {
                required.merge(item.getMilk(), 2 * quantity, Integer::sum);
            }

            if (item.getSyrup() != null) {
                required.merge(item.getSyrup(), quantity, Integer::sum);
            }
        }

        // Check the total requirements before deducting anything
        for (Map.Entry<Ingredient, Integer> entry : required.entrySet()) {
            if (!entry.getKey().hasQuantity(entry.getValue())) {
                return false;
            }
        }

        // Deduct all required ingredients
        for (Map.Entry<Ingredient, Integer> entry : required.entrySet()) {
            Ingredient ingredient = entry.getKey();
            ingredient.useQuantity(entry.getValue());
        }

        return true;
    }
}

