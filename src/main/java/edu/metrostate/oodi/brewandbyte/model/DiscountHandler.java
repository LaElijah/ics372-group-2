package edu.metrostate.oodi.brewandbyte.model;

import java.math.BigDecimal;

public interface DiscountHandler {

    BigDecimal getDiscount(BigDecimal subtotal);
}