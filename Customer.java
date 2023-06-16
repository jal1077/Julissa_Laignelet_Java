package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//  This method is meant to add the debit or profit together to see the overall balance with a foreach
    public int getBalance() {
        int balance = 0;
        for (AccountRecord debtOrProfit : charges) {
            balance += debtOrProfit.getCharge();
        }
        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

//  This method prints out the customer with its id, name, and balance
    @Override
    public String toString() {
        //update this
        String stringPrint = "Customer: id=" + id + ", name=" + name + ", balance=" + getBalance();
        return stringPrint;
    }
}
