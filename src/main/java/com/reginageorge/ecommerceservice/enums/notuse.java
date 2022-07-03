package com.reginageorge.ecommerceservice.enums;

public enum notuse {
    WATER(true, false),
    FRAGANCE(false, true),
    OILS(true, false);

    private final boolean isVegan;
    private final boolean isComedogenic;

    notuse(boolean isVegan, boolean isComedogenic) {
        this.isVegan = isVegan;
        this.isComedogenic = isComedogenic;
    }
}
