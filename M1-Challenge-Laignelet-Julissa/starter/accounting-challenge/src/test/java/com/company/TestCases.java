package com.company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class TestCases {
    Customer customer;

    @BeforeEach
    public void setUp() {
       customer = new Customer();
    }

    @Test
    public void testGetBalance() {
        customer.setId(1);
        customer.setName("Wayne Enterprises");

//      create an AccountRecord for the customer
        AccountRecord record1 = new AccountRecord();
        record1.setCharge(16000);
        record1.setChargeDate("07-16-2002");

        AccountRecord record2 = new AccountRecord();
        record2.setCharge(20000);
        record2.setChargeDate("06-15-2023");

        List<AccountRecord> charges = Arrays.asList(
                record1,
                record2
        );

        customer.getCharges().addAll(charges);

//      calculate the balance
        int balance = customer.getBalance();

//       Assert the balance is correct
        assertEquals(36000, balance);
    }

    @Test
    public void testToString() {
        customer.setId(3);
        customer.setName("Ace Chemical");

        //      create an AccountRecord for the customer
        AccountRecord record1 = new AccountRecord();
        record1.setCharge(20000);
        record1.setChargeDate("07-18-2002");

        AccountRecord record2 = new AccountRecord();
        record2.setCharge(22000);
        record2.setChargeDate("06-20-2023");

        AccountRecord record3 = new AccountRecord();
        record3.setCharge(24000);
        record3.setChargeDate("06-30-2023");

        List<AccountRecord> charges = Arrays.asList(
                record1,
                record2,
                record3
        );

        customer.getCharges().addAll(charges);

//      uses the toString functionality
        String customerToString = customer.toString();

//      compares to the expected string
        String expectedCustomerString = "Customer: id=3, name=Ace Chemical, balance=66000";

//      Assert the balance is correct
        assertEquals(expectedCustomerString, customerToString);
    }
}
