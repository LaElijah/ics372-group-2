package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;

public class LoyaltyDiscount implements DiscountHandler {

    @Override
    public BigDecimal getDiscount(BigDecimal subtotal) {
        return subtotal.multiply(new BigDecimal("0.10"));
    }
}