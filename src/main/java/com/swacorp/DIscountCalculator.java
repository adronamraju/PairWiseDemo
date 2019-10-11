package com.swacorp;

public class DIscountCalculator {


    public double getDiscount(String customerType, int numberOfItems, String state){
            CustomerType customerType1 = CustomerType.getCustomerFromString(customerType);
            State state1 = State.getStateFromString(state);
            if(customerType1 != null && state1 != null){
                int additionalWeight = 0;

                if(numberOfItems > 0){
                    if(numberOfItems > 1000){
                        additionalWeight = 15;
                    }else {
                        additionalWeight = 5;
                    }
                }

               else{
                    throw new RuntimeException("No Sale");
                }
                return state1.weight+ customerType1.weight + additionalWeight;
            }
            throw new RuntimeException("No Sale");
    }

}
