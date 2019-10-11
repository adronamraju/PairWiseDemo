package com.swacorp;

public enum CustomerType {
    LARGE_COMPANY(10),
    SMALL_COMPANY(5),
    INDIVIDUAL(5),
    INTERNATIONAL_COMPANY(5),
    INTERNATIONAL_INDIVIDUAL(5);

    public final int weight;

    CustomerType(int i) {
        this.weight = i;
    }

}
