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

    public static CustomerType getCustomerFromString(String string) {
        string = string.toUpperCase();
        switch (string) {
            case "LARGE_COMPANY":
                return LARGE_COMPANY;
            case "SMALL_COMPANY":
                return SMALL_COMPANY;
            case "INDIVIDUAL":
                return INDIVIDUAL;
            case "INTERNATIONAL_COMPANY":
                return INTERNATIONAL_COMPANY;
            case "INTERNATIONAL_INDIVIDUAL":
                return INTERNATIONAL_INDIVIDUAL;
            default:
                return null;
        }
    }

}
