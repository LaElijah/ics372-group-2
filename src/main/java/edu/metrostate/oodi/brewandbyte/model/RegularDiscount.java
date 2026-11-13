package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;

public class RegularDiscount implements DiscountHandler {

    @Override
    public BigDecimal getDiscount(BigDecimal subtotal) {
        return BigDecimal.ZERO;
    }
}