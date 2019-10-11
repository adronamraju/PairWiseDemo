package com.swacorp;

import com.swacorp.CustomerType;

public class CustomerFromString {
    public static CustomerType getCustomerFromString(String string) {
        string = string.toUpperCase();
        switch (string) {
            case "LARGE_COMPANY":
                return CustomerType.LARGE_COMPANY;
            case "SMALL_COMPANY":
                return CustomerType.SMALL_COMPANY;
            case "INDIVIDUAL":
                return CustomerType.INDIVIDUAL;
            case "INTERNATIONAL_COMPANY":
                return CustomerType.INTERNATIONAL_COMPANY;
            case "INTERNATIONAL_INDIVIDUAL":
                return CustomerType.INTERNATIONAL_INDIVIDUAL;
            default:
                return null;
        }
    }
}
