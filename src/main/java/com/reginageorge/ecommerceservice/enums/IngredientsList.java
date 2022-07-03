package com.reginageorge.ecommerceservice.enums;

public enum IngredientsList {
    WATER(true, false),
    FRAGANCE(false, true),
    OILS(true, false);

    private final boolean isVegan;
    private final boolean isComedogenic;

    IngredientsList(boolean isVegan, boolean isComedogenic) {
        this.isVegan = isVegan;
        this.isComedogenic = isComedogenic;
    }
}
