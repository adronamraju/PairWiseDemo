package com.swacorp;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(JUnit4.class)
public class DIscountCalculatorTest {

    @Test
    public void getDiscount() {
        DIscountCalculator discountCalculator = new DIscountCalculator();
        List<TestCaseInfo> testCaseInfos = readTestCases();
        for(TestCaseInfo testCaseInfo : testCaseInfos){
            System.out.println(testCaseInfo);
            if(Exception.class.equals(testCaseInfo.expectedValue)){

                try{
                    assertFalse(discountCalculator.getDiscount(testCaseInfo.customerType, testCaseInfo.items, testCaseInfo.state) > -1);
                }catch (RuntimeException r){
                    assertEquals(r.getMessage(), "No Sale");
                }
            }else{
                assertEquals(testCaseInfo.expectedValue, discountCalculator.getDiscount(testCaseInfo.customerType, testCaseInfo.items, testCaseInfo.state));
            }
        }
    }

    private List<TestCaseInfo> readTestCases() {

        try {
            CSVParser csvRecords = CSVParser.parse(this.getClass().getClassLoader().getResourceAsStream("testCases.csv"), Charset.defaultCharset(), CSVFormat.DEFAULT);

            List<TestCaseInfo> testcases = csvRecords.getRecords().stream().skip(1).map(record -> getTestCaseFromValue(record.get(1), record.get(2), record.get(3))).collect(Collectors.toList());
            return testcases;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private TestCaseInfo getTestCaseFromValue(String customer, String state, String countString) {
        TestCaseInfo testCaseInfo = new TestCaseInfo();
        if(customer != null)
            testCaseInfo.customerType = customer = customer.isEmpty() ? CustomerType.INDIVIDUAL.toString() : customer;
        if(state != null)
            testCaseInfo.state = state = state.isEmpty() ? State.MA.toString() : state;
        testCaseInfo.items = countString.equals("null") ? 0 : Integer.valueOf(countString);
        Double expectedVal = 0.0;
        if(!(customer.equals("null") || state.equals("null") || customer.equalsIgnoreCase("unknown") || state.equalsIgnoreCase("unknown")) ){
            if(testCaseInfo.items > 1000){
                expectedVal += 15;
            }else{
                expectedVal += 5;
            }
            expectedVal += (CustomerFromString.getCustomerFromString(customer)).weight + (StateFromString.getStateFromString(state)).weight;
            if(testCaseInfo.items > 0)
                testCaseInfo.expectedValue = expectedVal;
            else{
                testCaseInfo.expectedValue = Exception.class;
            }
        }else
            testCaseInfo.expectedValue = Exception.class;

        return testCaseInfo;
    }


    class TestCaseInfo {
        Integer items;
        String customerType;
        String state;
        Object expectedValue;

        @Override
        public String toString() {
            return "TestCaseInfo{" +
                    "items=" + items +
                    ", customerType='" + customerType + '\'' +
                    ", state='" + state + '\'' +
                    ", expectedValue=" + expectedValue +
                    '}';
        }
    }
}
